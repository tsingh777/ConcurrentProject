import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Simulator {

	public static void main(String[] args) {
		Bank bank = new Bank(new File("accounts.txt"), 0);
		List<User> users = bank.getUsers();
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (User user : users) {
			executor.execute(user);
		}
		executor.shutdown();
		
		while (!executor.isTerminated()) {
		}

		System.out.println("Finished all threads");

	}

	public void createAccounts() {
		try {
			PrintWriter pw = new PrintWriter("accounts.txt");
			for (int i = 0; i < 10; i++) {
				pw.println(i + " " + (int) (Math.random() * 10000) + ".00");
			}
			pw.flush();
			pw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
