
public class SynchronizedAccount extends BankAccount {

	public SynchronizedAccount(int accountNumber, double avalibleAmount) {
		super(accountNumber, avalibleAmount);
	}

	public synchronized void deposit(double amount) {
		super.deposit(amount);
	}
	
	public synchronized double withdraw(double amount) {
		return super.withdraw(amount);
	}
	
	public synchronized double getBalance() {
		return super.getBalance();
	}

	public synchronized void setbalance(double avalibleAmount) {
		super.setbalance(avalibleAmount);
	}
}
