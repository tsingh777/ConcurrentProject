import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantAccount extends BankAccount {
	private final Lock lock;
	
	public ReentrantAccount(int accountNumber, long balance) {
		super(accountNumber, balance);
		lock = new ReentrantLock();
	}
	
	public void deposit(long amount) {
		lock.lock();
		try {
			super.deposit(amount);
		}
		finally {
			lock.unlock();
		}
	}
	
	public long withdraw(long amount) {
		lock.lock();
		try {
			return super.withdraw(amount);
		}
		finally {
			lock.unlock();
		}
	}
	
	public long getBalance() {
		lock.lock();
		try {
			return super.getBalance();
		}
		finally {
			lock.unlock();
		}
	}

	public void setbalance(long avalibleAmount) {
		lock.lock();
		try {
			super.setbalance(avalibleAmount);
		}
		finally {
			lock.unlock();
		}
	}
}
