import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantAccount extends BankAccount {
	private double balance;
	private int accountNumber;
	private Lock lock;
	
	public ReentrantAccount() {
		this.balance = 4000.00;
		this.balance = 0;
		lock = new ReentrantLock();
	}
	
	public ReentrantAccount(double balance, int accountNumber) {
		this.balance = balance;
		this.accountNumber = accountNumber;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public double withdraw(double amount) {
		if(balance < 0) {
			return -1;
		}
		else if((balance-amount < 0)) {
			return -1;
		}
		else {
			balance -= amount;
			return amount;
		}
	}
}
