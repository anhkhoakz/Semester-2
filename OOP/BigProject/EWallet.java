public class EWallet implements Payment, Transfer {
	private int phoneNumber;
	private double accountBalance;

	public EWallet(int phoneNumber) {
		setPhoneNumber(phoneNumber);
		setAccountBalance(0);
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public double checkBalance() {
		return this.accountBalance;
	}

	public void topUp(double amountOfMoney) {
		this.accountBalance += amountOfMoney;
	}

	public String toString() {
		return getPhoneNumber() + "," + checkBalance();
	}

	public boolean transfer(double amount, Transfer to) {
		double totalAmount = amount * (1 + transferFee);

		if (checkBalance() >= totalAmount) {
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
		if (amount <= checkBalance()) {
			this.accountBalance -= amount;
			return true;
		} else {
			return false;
		}
	}

}