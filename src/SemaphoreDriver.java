import java.io.File;
import java.util.*;


public class SemaphoreDriver {
	public static void main(String[] args){
		final BankAccount account1= new SemaphoreAccount(1, 300);
		final BankAccount account2= new SemaphoreAccount(2, 300);
		final BankAccount account3= new SemaphoreAccount(3, 300);
		
		Thread t1= new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("t1:"+ account1.getAccountNumber());
				System.out.println("T1 reads accouunt 1 " + account1.getBalance());
				account1.withdraw(150);
				System.out.println("T1 reads accouunt 1 " + account1.getBalance());
				account1.deposit(290);
				System.out.println("T1 reads accouunt 1 " + account1.getBalance());

			}
			
			
		});
		
		
		Thread t2= new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("t2:"+account1.getAccountNumber());
				System.out.println("Thread 2 reads accouunt 1 " + account1.getBalance());
				account1.deposit(2110);
				System.out.println("Thread 2 reads accouunt 1 " + account1.getBalance());
				account1.deposit(2010);
				System.out.println("Thread 2 reads accouunt 1 " + account1.getBalance());

			}
			
			
		});
		; 
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			System.out.println(account1.getBalance());
		}
		
		
	
		//Bank bank = new Bank(new File("accounts.txt"), 0);
		//System.out.print(bank.getAccounts().toString());
		//List<Thread> transactions = new Vector<Thread>();
		//for(BankAccount ob : bank.getAccounts()){
			
			/*transactions.add(new Thread(new Runnable(){

				@Override
				public void run() {
					
					
				}
				
			}));*/
		//}
		
		
	}
}
