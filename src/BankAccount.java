public abstract class BankAccount {
	private double balance;
	private int accountNumber;

	public BankAccount() {
		this.balance = 4000.00;// start with 4000?
	}

	public BankAccount(double avalibleAmount) {
		this.balance = avalibleAmount;
	}
	
	public BankAccount(double avalibleAmount, int accountNumber) {
		this.balance = avalibleAmount;
		this.accountNumber = accountNumber;
	}

	/**
	 * add to the amount avalible
	 * 
	 * @param amount
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}

	/**
	 * remove from amount avalible
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
	 * @return the balace
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

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

}
