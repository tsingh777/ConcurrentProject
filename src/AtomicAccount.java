import java.util.concurrent.atomic.AtomicLong;

public class AtomicAccount extends BankAccount {
	private AtomicLong balance = new AtomicLong();

	public AtomicAccount(int accountNumber, long avalibleAmount) {
		super(accountNumber, avalibleAmount);
		balance.set(avalibleAmount);
	}
	
	public void deposit(long amount) {
		balance.getAndAdd((long)amount);
	}
	
	public long withdraw(long amount) {
		return super.withdraw(amount);
	}
	
	public long getBalance() {
		return super.getBalance();
	}

	public void setbalance(long avalibleAmount) {
		super.setbalance(avalibleAmount);
	}

}
