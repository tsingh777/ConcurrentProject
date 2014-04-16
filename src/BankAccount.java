public abstract class BankAccount {
	private long balance;
	private final int accountNumber;

	public BankAccount(int accountNumber, long balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	/**
	 * add to the amount available
	 * 
	 * @param amount
	 */
	public void deposit(long amount) {
		balance += amount;
	}

	/**
	 * remove from amount available
	 * 
	 * @param amount
	 * @return balance after withdraw
	 */
	public long withdraw(long amount) {
		if (amount > balance) {
			return 0;
		} else {
			balance -= amount;
			return balance;
		}
	}

	/**
	 * @return the balance
	 */
	public long getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setbalance(long balance) {
		this.balance = balance;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

}
