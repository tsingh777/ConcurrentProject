import java.util.concurrent.atomic.AtomicLong;

public class AtomicAccount extends BankAccount {
	private AtomicLong balance = new AtomicLong();

	public AtomicAccount(int accountNumber, long avalibleAmount) {
		super(accountNumber, avalibleAmount);
		balance.set(avalibleAmount);
	}
	
	public void deposit(long amount) {
		balance.getAndAdd(amount);
	}
	
	public long withdraw(long amount) {
		return balance.getAndAdd(-amount);
	}
	
	public long getBalance() {
		return balance.get();
	}

	public void setbalance(long avalibleAmount) {
		balance.set(avalibleAmount);
	}

}
