import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Bank {

	private Map<Integer, BankAccount> accounts;
	
	public Bank(File file, int arg) {
		Scanner s; 
		try{
			s = new Scanner(file);
			accounts = new HashMap<Integer, BankAccount>();
			String[] str;
			switch (arg) {
			case 0:
				while(s.hasNext()){
					str = s.nextLine().split(" ");
					int accNum = Integer.parseInt(str[0]);
					double balance = Double.parseDouble(str[1]);
					accounts.put(accNum, new SemaphoreAccount(accNum,  balance));
				}
				break;
			case 1:
				while(s.hasNext()){
					str = s.nextLine().split(" ");
					int accNum = Integer.parseInt(str[0]);
					double balance = Double.parseDouble(str[1]);
					//reentrant
				}
				break;
			case 2:
				while(s.hasNext()){
					str = s.nextLine().split(" ");
					int accNum = Integer.parseInt(str[0]);
					double balance = Double.parseDouble(str[1]);
					// blocking
				}
				break;
			default:
				break;
			}
			s.close();
		}catch(IOException e) {
			
		}
	}

	/**
	 * @return the accounts
	 */
	public Map<Integer, BankAccount> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(Map<Integer, BankAccount> accounts) {
		this.accounts = accounts;
	}

	public void getBalance(BankAccount acc) {
		accounts.get(acc.getAccountNumber()).getBalance();		
	}

	public void deposit(BankAccount acc, double amount) {
		accounts.get(acc.getAccountNumber()).deposit(amount);
	}

	public void withdraw(BankAccount acc, double amount) {
		accounts.get(acc.getAccountNumber()).withdraw(amount);
	}

	public void transfer(BankAccount acc, int accNum, double amount) {
		accounts.get(acc.getAccountNumber()).withdraw(amount);
		accounts.get(accNum).deposit(amount);
	}

}
