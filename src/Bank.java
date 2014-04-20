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
		try {
			s = new Scanner(file);
			accounts = new HashMap<Integer, BankAccount>();
			users = new ArrayList<User>();
			String[] str;
			switch (arg) {
			case 0:
				while (s.hasNext()) {
					str = s.nextLine().split(" ");
					int accNum = Integer.parseInt(str[0]);
					long balance = (long) Double.parseDouble(str[1]);
					BankAccount acc = new SynchronizedAccount(accNum, balance);
					accounts.put(accNum, acc);
					users.add(new User(this, acc));
				}
				break;
			case 1:
				while (s.hasNext()) {
					str = s.nextLine().split(" ");
					int accNum = Integer.parseInt(str[0]);
					long balance = (long) Double.parseDouble(str[1]);
					BankAccount acc = new ReentrantAccount(accNum, balance);
					accounts.put(accNum, acc);
					users.add(new User(this, acc));
				}
				break;
			case 2:
				while (s.hasNext()) {
					str = s.nextLine().split(" ");
					int accNum = Integer.parseInt(str[0]);
					long balance = (long) Double.parseDouble(str[1]);
					BankAccount acc = new AtomicAccount(accNum, balance);
					accounts.put(accNum, acc);
					users.add(new User(this, acc));
				}
				break;
			case 3:
				while (s.hasNext()) {
					str = s.nextLine().split(" ");
					int accNum = Integer.parseInt(str[0]);
					long balance = (long) Double.parseDouble(str[1]);
					BankAccount acc = new SemaphoreAccount(accNum, balance);
					accounts.put(accNum, acc);
					users.add(new User(this, acc));
				}
				break;
			case 4:
				while (s.hasNext()) {
					str = s.nextLine().split(" ");
					int accNum = Integer.parseInt(str[0]);
					long balance = (long) Double.parseDouble(str[1]);
					BankAccount acc = new ControlAccount(accNum, balance);
					accounts.put(accNum, acc);
					users.add(new User(this, acc));
				}
			default:
				break;
			}
			s.close();
		} catch (IOException e) {

		}
	}

	/**
	 * @return the accounts
	 */
	public Map<Integer, BankAccount> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts
	 *            the accounts to set
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

	public void deposit(BankAccount acc, long amount) {
		accounts.get(acc.getAccountNumber()).deposit(amount);
	}

	public void withdraw(BankAccount acc, long amount) {
		accounts.get(acc.getAccountNumber()).withdraw(amount);
	}

	public synchronized void transfer(BankAccount acc, int accNum, long amount) {
		accounts.get(acc.getAccountNumber()).withdraw(amount);
		accounts.get(accNum).deposit(amount);
	}

}
