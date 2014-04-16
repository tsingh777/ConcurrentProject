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
//		int count = 0;
//		while (count < 100000) {
//			switch ((int) (Math.random() * 4)) {
//			case 0:
//				viewBalance();
//				break;
//			case 1:
//				deposit(100);
//				viewBalance();
//				break;
//			case 2:
//				withdraw(100);
//				viewBalance();
//				break;
//			case 3:
//				int accNum = acc.getAccountNumber();
//				if(accNum == 9){
//					accNum = 0;
//				}
//				transfer(accNum, 100);
//				viewBalance();
//				break;
//			default:
//				break;
//			}
//			count++;
//		}
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
