public abstract class BankAccount {
	private double balance;
	private final int accountNumber;

	public BankAccount(int accountNumber, double avalibleAmount) {
		this.accountNumber = accountNumber;
		this.balance = avalibleAmount;
	}

	/**
	 * add to the amount available
	 * 
	 * @param amount
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}

	/**
	 * remove from amount available
	 * 
	 * @param amount
	 * @return avalibleAmount after withdraw
	 */
	public double withdraw(double amount) {
		if (amount > this.balance) {
			return 0;
		} else {
			this.balance -= amount;
			return (this.balance);
		}
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param avalibleAmount
	 *            the avalibleAmount to set
	 */
	public void setbalance(double avalibleAmount) {
		this.balance = avalibleAmount;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

}
