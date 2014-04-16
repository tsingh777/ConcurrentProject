import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Bank {

	private Map<Integer, BankAccount> accounts;
	private List<User> users;

	public Bank(File file, int arg) {
		Scanner s; 
		try{
			s = new Scanner(file);
			accounts = new HashMap<Integer, BankAccount>();
			users = new ArrayList<User>();
			String[] str;
			switch (arg) {
			case 0:
				while(s.hasNext()){
					str = s.nextLine().split(" ");
					int accNum = Integer.parseInt(str[0]);
					double balance = Double.parseDouble(str[1]);
					BankAccount acc =  new SemaphoreAccount(accNum,  balance);
					accounts.put(accNum, acc);
					users.add(new User(this, acc));
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
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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
