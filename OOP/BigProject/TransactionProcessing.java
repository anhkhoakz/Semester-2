import java.util.*;
import java.io.*;

public class TransactionProcessing {
    private ArrayList<Payment> paymentObjects;
    private IDCardManagement idcm;

    public TransactionProcessing(String idCardPath, String paymentPath) {
        idcm = new IDCardManagement(idCardPath);
        readPaymentObject(paymentPath);

    }

    public ArrayList<Payment> getPaymentObject() {
        return this.paymentObjects;
    }

    // Requirement 3
    public boolean readPaymentObject(String path) {
        paymentObjects = new ArrayList<>();
        ArrayList<IDCard> idcards = idcm.getIDCards();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitData = line.split(",");
                int splitLength = splitData.length;
                int lineLength = line.length();

                if (splitLength == 1) {
                    if (lineLength == 6) {
                        int IDNumber = Integer.parseInt(line);
                        IDCard matchingIDCard = null;
                        for (IDCard idcard : idcards) {
                            if (idcard.getID() == IDNumber) {
                                matchingIDCard = idcard;
                                break;
                            }
                        }

                        if (matchingIDCard != null) {
                            ConvenientCard convenientCard;
                            try {
                                convenientCard = new ConvenientCard(matchingIDCard);
                                convenientCard.getType();
                                paymentObjects.add(convenientCard);
                            } catch (CannotCreateCard e) {
                                System.out.println("Not enough age");
                            }
                        }
                    } else if (lineLength == 7) {
                        int phoneNumber = Integer.parseInt(line);
                        EWallet eWallet = new EWallet(phoneNumber);
                        paymentObjects.add(eWallet);
                    }
                } else if (splitLength == 2) {
                    int bankID = Integer.parseInt(splitData[0]);
                    double interestRate = Double.parseDouble(splitData[1]);
                    BankAccount bankAccount = new BankAccount(bankID, interestRate);
                    paymentObjects.add(bankAccount);
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Requirement 4
    public ArrayList<ConvenientCard> getAdultConvenientCards() {
        ArrayList<ConvenientCard> adultCards = new ArrayList<>();
        for (Payment payment : paymentObjects) {
            if (payment instanceof ConvenientCard) {
                ConvenientCard card = (ConvenientCard) payment;
                String cardType = card.getType();
                if ("Adult".equalsIgnoreCase(cardType)) {
                    adultCards.add(card);
                }
            }
        }
        return adultCards;
    }

    // Requirement 5
    public ArrayList<IDCard> getCustomersHaveBoth() {
        ArrayList<IDCard> customersHaveBoth = new ArrayList<>();

        for (IDCard customer : idcm.getIDCards()) {
            boolean hasConvenientCard = false;
            boolean hasEWallet = false;
            boolean hasBankAccount = false;

            for (Payment payment : paymentObjects) {
                if (payment instanceof ConvenientCard) {
                    ConvenientCard convenientCard = (ConvenientCard) payment;
                    if (convenientCard.getIDCard().getID() == customer.getID()) {
                        hasConvenientCard = true;
                    }
                } else if (payment instanceof EWallet) {
                    EWallet eWallet = (EWallet) payment;
                    if (eWallet.getPhoneNumber() == customer.getPhoneNumber()) {
                        hasEWallet = true;
                    }
                } else if (payment instanceof BankAccount) {
                    BankAccount bankAccount = (BankAccount) payment;
                    if (bankAccount.getAccountNumber() == customer.getID()) {
                        hasBankAccount = true;
                    }
                }

                if (hasConvenientCard && hasEWallet && hasBankAccount) {
                    customersHaveBoth.add(customer);
                    break;
                }
            }
        }

        return customersHaveBoth;
    }

    // Requirement 6
    public void processTopUp(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] topUpData = line.split(",");
                String accountType = topUpData[0];
                int accountID = Integer.parseInt(topUpData[1]);
                double amount = Double.parseDouble(topUpData[2]);

                for (Payment payment : paymentObjects) {
                    if (accountType.equalsIgnoreCase("CC") && payment instanceof ConvenientCard) {
                        ConvenientCard convenientCard = (ConvenientCard) payment;
                        if (convenientCard.getIDCard().getID() == accountID) {
                            convenientCard.topUp(amount);
                            break;
                        }
                    } else if (accountType.equalsIgnoreCase("EW") && payment instanceof EWallet) {
                        EWallet eWallet = (EWallet) payment;
                        if (eWallet.getPhoneNumber() == accountID) {
                            eWallet.topUp(amount);
                            break;
                        }
                    } else if (accountType.equalsIgnoreCase("BA") && payment instanceof BankAccount) {
                        BankAccount bankAccount = (BankAccount) payment;
                        if (bankAccount.getAccountNumber() == accountID) {
                            bankAccount.topUp(amount);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Requirement 7
    public ArrayList<Bill> getUnsuccessfulTransactions(String path) {
        ArrayList<Bill> unsuccessfulTransactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] payData = line.split(",");
                int billID = Integer.parseInt(payData[0]);
                double amount = Double.parseDouble(payData[1]);
                String paymentPurpose = payData[2];
                String accountType = payData[3];
                int accountID = Integer.parseInt(payData[4]);

                for (Payment payment : paymentObjects) {
                    if (accountType.equalsIgnoreCase("CC") && payment instanceof ConvenientCard) {
                        ConvenientCard convenientCard = (ConvenientCard) payment;
                        if (convenientCard.getIDCard().getID() == accountID) {
                            if (!convenientCard.pay(amount)) {
                                unsuccessfulTransactions.add(new Bill(billID, amount, paymentPurpose));
                            }
                            break;
                        }
                    } else if (accountType.equalsIgnoreCase("EW") && payment instanceof EWallet) {
                        EWallet eWallet = (EWallet) payment;
                        if (eWallet.getPhoneNumber() == accountID) {
                            if (!eWallet.pay(amount)) {
                                unsuccessfulTransactions.add(new Bill(billID, amount, paymentPurpose));
                            }
                            break;
                        }
                    } else if (accountType.equalsIgnoreCase("BA") && payment instanceof BankAccount) {
                        BankAccount bankAccount = (BankAccount) payment;
                        if (bankAccount.getAccountNumber() == accountID) {
                            if (!bankAccount.pay(amount)) {
                                unsuccessfulTransactions.add(new Bill(billID, amount, paymentPurpose));
                            }
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return unsuccessfulTransactions;
    }

    // Requirement 8
    public ArrayList<BankAccount> getLargestPaymentByBA(String path) {
        ArrayList<BankAccount> bankAccountsMax = new ArrayList<>();
        BankAccount maxPaymentBankAccount = null;
        double maxPaymentAmount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] payData = line.split(",");
                double amount = Double.parseDouble(payData[1]);
                String accountType = payData[3];
                int accountID = Integer.parseInt(payData[4]);

                if (accountType.equalsIgnoreCase("BA")) {
                    for (Payment payment : paymentObjects) {
                        if (payment instanceof BankAccount) {
                            BankAccount bankAccount = (BankAccount) payment;
                            if (bankAccount.getAccountNumber() == accountID && bankAccount.pay(amount)) {
                                if (amount > maxPaymentAmount) {
                                    maxPaymentAmount = amount;
                                    maxPaymentBankAccount = bankAccount;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (maxPaymentBankAccount != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] payData = line.split(",");
                    String accountType = payData[3];
                    int accountID = Integer.parseInt(payData[4]);

                    if (accountType.equalsIgnoreCase("BA") && maxPaymentBankAccount.getAccountNumber() == accountID) {
                        double amount = Double.parseDouble(payData[1]);
                        if (amount == maxPaymentAmount) {
                            bankAccountsMax.add(maxPaymentBankAccount);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bankAccountsMax;
    }

    // Requirement 9
    public void processTransactionWithDiscount(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] payData = line.split(",");
                double amount = Double.parseDouble(payData[1]);
                String paymentPurpose = payData[2];
                String accountType = payData[3];
                int accountID = Integer.parseInt(payData[4]);

                for (Payment payment : paymentObjects) {
                    if (accountType.equalsIgnoreCase("CC") && payment instanceof ConvenientCard) {
                        ConvenientCard convenientCard = (ConvenientCard) payment;
                        if (convenientCard.getIDCard().getID() == accountID && convenientCard.pay(amount)) {
                            break;
                        }
                    } else if (accountType.equalsIgnoreCase("BA") && payment instanceof BankAccount) {
                        BankAccount bankAccount = (BankAccount) payment;
                        if (bankAccount.getAccountNumber() == accountID && bankAccount.pay(amount)) {
                            break;
                        }
                    } else if (accountType.equalsIgnoreCase("EW") && payment instanceof EWallet) {
                        EWallet eWallet = (EWallet) payment;
                        if (eWallet.getPhoneNumber() == accountID) {
                            if (amount > 500 && paymentPurpose.equalsIgnoreCase("Clothing")) {
                                for (IDCard idCard : idcm.getIDCards()) {
                                    String sex = idCard.getSex();
                                    int age = idCard.getAge();

                                    boolean isValid = (sex.equalsIgnoreCase("Male") && age < 18)
                                            || (sex.equalsIgnoreCase("Female") && age < 20);

                                    if (isValid) {
                                        double discountRate = 0.15;
                                        eWallet.pay(amount * (1 - discountRate));
                                        break;
                                    }
                                }
                            } else {
                                eWallet.pay(amount);
                            }
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}