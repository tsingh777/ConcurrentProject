public class User implements Runnable {
	private Bank bank;
	private BankAccount acc;

	public User(Bank bank, BankAccount acc) {
		this.bank = bank;
		this.acc = acc;
	}

	@Override
	public void run() {
		if(acc.getAccountNumber() != 1)
			transfer(1,1);
		else
			withdraw(1);
	}

	public void viewBalance() {
		bank.getBalance(acc);
	}

	public void deposit(double amount) {
		bank.deposit(acc, amount);
	}

	public void withdraw(double amount) {
		bank.withdraw(acc, amount);
	}

	public void transfer(int accNum, double amount) {
		bank.transfer(acc, accNum, amount);
	}
}
