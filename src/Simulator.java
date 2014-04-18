import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Simulator {

	public static void main(String[] args) {
		createActions(10, 100);
//		Bank bank = new Bank(new File("accounts.txt"), 3);
//		List<User> users = bank.getUsers();
//		ExecutorService executor = Executors.newFixedThreadPool(16);
//		for (User user : users) {
//			executor.execute(user);
//		}
//		executor.shutdown();
//
//		while (!executor.isTerminated()) {
//		}
//
//		System.out.println("Finished all threads");

	}

	public void createAccounts(int numUsers) {
		try {
			PrintWriter pw = new PrintWriter("accounts.txt");
			for (int i = 0; i < numUsers; i++) {
				pw.println(i + " " + (int) (Math.random() * 10000) + ".00");
			}
			pw.flush();
			pw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createActions(int numUsers, int numActions) {
		try {
			PrintWriter pw = new PrintWriter("user_actions.txt");
			for (int i = 0; i < numUsers; i++) {
				pw.println("user "+i);
				for (int j = 0; j < numActions; j++) {
					/*
					 * actions 0 - viewBalance: 0 1 - deposit : 1 100 means
					 * deposit 100 2 - withdraw : 2 100 means withdraw 100 3 -
					 * transfer : 3 5 100 means transfer 500 to account number 5
					 */
					int act = (int) (Math.random() * 4);
					String actionString = "";
					switch (act) {
					case 0:
						actionString = "0";
						break;
					case 1:
						actionString = "1 " + ((int) (Math.random() * 100)+1);
						break;
					case 2:
						actionString = "2 " + ((int) (Math.random() * 100)+1);
						break;
					case 3:
						int otherUser = (int) (Math.random() * numUsers);
						if (otherUser == i) {
							if (otherUser == numUsers - 1)
								otherUser = 0;
							else
								otherUser++;
						}
						actionString = "3 " + otherUser + " "
								+ ((int) (Math.random() * 100)+1);
						break;
					default:
						break;
					}
					pw.println(actionString);
				}
			}
			pw.flush();
			pw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
