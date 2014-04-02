
public class User implements Runnable{
	private BankAccount acc;

	public User(BankAccount acc) {
		this.acc = acc;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void viewBalance(){
		acc.getBalance();
	}
	
	public void deposit(double amount){
		acc.deposit(amount);
	}
	
	public void withdraw(double amount){
		acc.withdraw(amount);
	}

	public void transfer(int accNum, double amount){
		//transfer
	}
}
