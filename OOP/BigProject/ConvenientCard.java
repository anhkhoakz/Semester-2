public class ConvenientCard implements Payment {
	private String type;
	private IDCard idCard;
	private double accountBalance;

	public ConvenientCard(IDCard idCard) throws CannotCreateCard {
		setIDCard(idCard);
		setAccountBalance(100);
		setType(idCard);
	}

	public void setIDCard(IDCard idCard) {
		this.idCard = idCard;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void setType(IDCard idCard) throws CannotCreateCard {
		int age = idCard.getAge();
		int minAge = 12;
		int studentAge = 18;
		if (age < minAge) {
			throw new CannotCreateCard("Not enough age");
		} else if (age <= studentAge) {
			type("Student");
		} else {
			type("Adult");
		}
	}

	private void type(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public IDCard getIDCard() {
		return this.idCard;
	}

	public double checkBalance() {
		return this.accountBalance;
	}

	public void topUp(double amountOfMoney) {
		this.accountBalance += amountOfMoney;
	}

	public String toString() {
		return getIDCard() + "," + getType() + "," + checkBalance();
	}

	public boolean pay(double amount) {
		double totalAmount;
		if (getType().equalsIgnoreCase("student")) {
			totalAmount = amount;
		} else {
			double fee = 0.01;
			totalAmount = amount * (1 + fee);
		}

		if (checkBalance() >= totalAmount) {
			this.accountBalance -= totalAmount;
			return true;
		} else {
			return false;
		}
	}
}