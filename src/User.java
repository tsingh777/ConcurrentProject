
public class User implements Runnable{
	private Bank bank;
	private BankAccount acc;

	public User(Bank bank, BankAccount acc) {
		this.bank = bank;
		this.acc = acc;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void viewBalance(){
		bank.getBalance(acc);
	}
	
	public void deposit(double amount){
		bank.deposit(acc, amount);
	}
	
	public void withdraw(double amount){
		bank.withdraw(acc, amount);
	}

	public void transfer(int accNum, double amount){
		bank.transfer(acc, accNum, amount);
	}
}
