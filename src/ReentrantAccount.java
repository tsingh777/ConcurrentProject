import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantAccount extends BankAccount {
	private final Lock lock;
	
	public ReentrantAccount(double balance, int accountNumber) {
		super(accountNumber, balance);
		lock = new ReentrantLock();
	}
	
	public void deposit(double amount) {
		lock.lock();
		try {
			super.deposit(amount);
		}
		finally {
			lock.unlock();
		}
	}
	
	public double withdraw(double amount) {
		lock.lock();
		try {
			return super.withdraw(amount);
		}
		finally {
			lock.unlock();
		}
	}
}
