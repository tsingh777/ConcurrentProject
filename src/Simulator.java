import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Simulator {

	public static void main(String[] args) {
		// createActions(10, 100);
		Bank bank = new Bank(new File("accounts.txt"), 3);
		List<User> users = bank.getUsers();
		setUserActions(new File("user_actions.txt"), users, 100);
		ExecutorService executor = Executors.newFixedThreadPool(16);
		for (User user : users) {
			executor.execute(user);
		}
		executor.shutdown();

		while (!executor.isTerminated()) {
		}

		for (User user : users) {
			System.out.println(user.getAccount().getAccountNumber() + " - "
					+ user.getAccount().getBalance());
		}

		System.out.println("Finished all threads");

	}

	public static void setUserActions(File file, List<User> users,
			int numActions) {
		Scanner s;
		try {
			s = new Scanner(file);
			while (s.hasNextLine()) {
				if (s.nextLine().equals("user")) {
					int userNum = Integer.parseInt(s.nextLine());
					List<Action> actions = new ArrayList<Action>();
					for (int i = 0; i < numActions; i++) {
						String t = s.nextLine();
						String a[] = t.split(" ");
						switch (Integer.parseInt(a[0])) {
						case 0:
							actions.add(new Action(0));
							break;
						case 1:
							actions.add(new Action(1, Long.parseLong(a[1])));
							break;
						case 2:
							actions.add(new Action(2, Long.parseLong(a[1])));
							break;
						case 3:
							actions.add(new Action(3, Long.parseLong(a[2]),
									Integer.parseInt(a[1])));
							break;

						default:
							break;
						}
					}
					users.get(userNum).setActions(actions);
				}
			}
		} catch (IOException e) {

		}
	}

	public static void createAccounts(int numUsers) {
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
				pw.println("user");
				pw.println(i);
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
						actionString = "1 " + ((int) (Math.random() * 100) + 1);
						break;
					case 2:
						actionString = "2 " + ((int) (Math.random() * 100) + 1);
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
								+ ((int) (Math.random() * 100) + 1);
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
