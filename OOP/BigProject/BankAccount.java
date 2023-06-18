public class BankAccount implements Payment, Transfer {
    private int accountNumber;
    private double interestRate;
    private double accountBalance;

    public BankAccount(int accountNumber, double interestRate) {
        setAccountNumber(accountNumber);
        setInterestRate(interestRate);
        setAccountBalance(50);
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public double checkBalance() {
        return this.accountBalance;
    }

    public void topUp(double amountOfMoney) {
        this.accountBalance += amountOfMoney;
    }

    public String toString() {
        return getAccountNumber() + "," + getInterestRate() + "," + checkBalance();
    }

    public boolean transfer(double amount, Transfer to) {
        double minBalance = 50;
        double totalAmount = amount * (1 + transferFee);
        double requiredBalance = totalAmount + minBalance;

        if (checkBalance() >= requiredBalance) {
            this.accountBalance -= totalAmount;

            if (to instanceof EWallet) {
                ((EWallet) to).topUp(amount);
            } else if (to instanceof BankAccount) {
                ((BankAccount) to).topUp(amount);
            }

            return true;
        }

        return false;
    }

    public boolean pay(double amount) {
        double minBalance = 50;
        double requiredBalance = amount + minBalance;
        if (requiredBalance <= accountBalance) {
            this.accountBalance -= amount;
            return true;
        } else {
            return false;
        }
    }

}
