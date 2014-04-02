import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Bank {

	private List<BankAccount> accounts;
	
	public Bank(File file, int arg) {
		Scanner s; 
		try{
			s = new Scanner(file);
			accounts = new ArrayList<BankAccount>();
			String[] str;
			switch (arg) {
			case 0:
				while(s.hasNext()){
					str = s.nextLine().split(" ");
					int accNum = Integer.parseInt(str[0]);
					double balance = Double.parseDouble(str[1]);
					accounts.add(new SemaphoreAccount(accNum,  balance));
				}
				break;
			case 1:
				while(s.hasNext()){
					str = s.nextLine().split(" ");
					int accNum = Integer.parseInt(str[0]);
					double balance = Double.parseDouble(str[1]);
				}
				break;
			case 2:
				while(s.hasNext()){
					str = s.nextLine().split(" ");
					int accNum = Integer.parseInt(str[0]);
					double balance = Double.parseDouble(str[1]);
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
	public List<BankAccount> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

}
