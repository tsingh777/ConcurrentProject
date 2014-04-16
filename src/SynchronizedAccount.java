
public class SynchronizedAccount extends BankAccount {

	public SynchronizedAccount(int accountNumber, long avalibleAmount) {
		super(accountNumber, avalibleAmount);
	}

	public synchronized void deposit(long amount) {
		super.deposit(amount);
	}
	
	public synchronized long withdraw(long amount) {
		return super.withdraw(amount);
	}
	
	public synchronized long getBalance() {
		return super.getBalance();
	}

	public synchronized void setbalance(long avalibleAmount) {
		super.setbalance(avalibleAmount);
	}
}
