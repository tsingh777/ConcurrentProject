
public class User implements Runnable{
	private Bank bank;
	private BankAccount acc;

	public User(Bank bank, BankAccount acc) {
		this.bank = bank;
		this.acc = acc;
	}

	@Override
	public void run() {
		switch((int)(Math.random()*4)){
		case 0:
			viewBalance();
			break;
		case 1:
			deposit(100);
			break;
		case 2:
			withdraw(100);
			break;
		case 3:
			transfer((int)(Math.random()*9),100);
		default:
			break;
		}
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
