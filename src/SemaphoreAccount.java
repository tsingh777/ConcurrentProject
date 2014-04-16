import java.util.concurrent.*;


public class SemaphoreAccount extends BankAccount {
	
	Semaphore sempahore = new Semaphore(1);
	
	
	public SemaphoreAccount(int accountNum, double balance) {
		super(accountNum, balance);
	}

 
	@Override
	public void deposit(double amount) {
		try{
		//	System.out.println("P()");
			this.sempahore.acquire();
			super.deposit(amount);
			//System.out.println(Thread.currentThread().toString() + " deposited " + amount);
			this.sempahore.release();
		//	System.out.println("V()");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}



	@Override
	public double withdraw(double amount) {
		double result =0;
		try{
		//	System.out.println("P()");
			this.sempahore.acquire();;
			result= super.withdraw(amount);
			//System.out.println( Thread.currentThread().toString()+ " withdrew from account " + this.getAccountNumber() + " amount" + result);
			this.sempahore.release();
			//System.out.println("V()");

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public double getBalance() {
		double result =0;
		try{
			//System.out.println("P()");
			this.sempahore.acquire();
			result= super.getBalance();
			//System.out.println( Thread.currentThread().toString()+" got balance for account" + this.getAccountNumber());
			this.sempahore.release();
		//	System.out.println("V()");

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	

}
