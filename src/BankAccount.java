public abstract class BankAccount {
	private long balance;
	private final int accountNumber;

	public BankAccount(int accountNumber, long avalibleAmount) {
		this.accountNumber = accountNumber;
		this.balance = avalibleAmount;
	}

	/**
	 * add to the amount available
	 * 
	 * @param amount
	 */
	public void deposit(long amount) {
		this.balance += amount;
	}

	/**
	 * remove from amount available
	 * 
	 * @param amount
	 * @return avalibleAmount after withdraw
	 */
	public long withdraw(long amount) {
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
	public long getBalance() {
		return balance;
	}

	/**
	 * @param avalibleAmount
	 *            the avalibleAmount to set
	 */
	public void setbalance(long avalibleAmount) {
		this.balance = avalibleAmount;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

}
