import java.util.ArrayList;
import java.util.List;

public class User implements Runnable {
	private Bank bank;
	private BankAccount acc;
	private List<Action> actions;

	public User(Bank bank, BankAccount acc) {
		this.bank = bank;
		this.acc = acc;
		this.actions = new ArrayList<Action>();
	}

	@Override
	public void run() {
		for (Action action : actions) {
			long amount = action.amount;
			int accNum = action.transferTo;
			switch (action.actionCode) {
			case 0:
				viewBalance();
				break;
			case 1:
				deposit(amount);
				break;
			case 2:
				withdraw(amount);
				break;
			case 3:
				transfer(accNum, amount);
				break;
			default:
				break;
			}
		}
	}

	public void viewBalance() {
		bank.getBalance(acc);
	}

	public void deposit(long amount) {
		bank.deposit(acc, amount);
	}

	public void withdraw(long amount) {
		bank.withdraw(acc, amount);
	}

	public void transfer(int accNum, long amount) {
		bank.transfer(acc, accNum, amount);
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
	public BankAccount getAccount(){
		return this.acc;
	}
}
