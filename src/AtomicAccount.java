import java.util.concurrent.atomic.AtomicLong;

public class AtomicAccount extends BankAccount {
	private AtomicLong balance = new AtomicLong();

	public AtomicAccount(int accountNumber, double avalibleAmount) {
		super(accountNumber, avalibleAmount);
		balance.set((long) avalibleAmount);
	}
	
	public void deposit(double amount) {
		balance.getAndSet(balance.get() - (long)amount);
	}
	
	public double withdraw(double amount) {
		return super.withdraw(amount);
	}
	
	public double getBalance() {
		return super.getBalance();
	}

	public void setbalance(double avalibleAmount) {
		super.setbalance(avalibleAmount);
	}

}
