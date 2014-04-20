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
		// int x= 50000;
		// int numUsers = 16;
		// createAccounts(numUsers);
		// createActions(numUsers, x);//create x number of random acions for each user. 

		for (int bankType = 0; bankType < 4; bankType++) { //Do the test for each bank account type 
			System.out.print("bank"+bankType+"\t");
			for (int actNum = 10000; actNum <= 50000; actNum += 5000) { // run through the different files containning the actions.
				long[] time = new long[10];
				for (int i = 0; i < 10; i++) {	//Do the test 10 times.
					Bank bank = new Bank(new File("accounts.txt"), bankType);
					List<User> users = bank.getUsers();
					setUserActions(new File("actions"+actNum), users,
							actNum);
					ExecutorService executor = Executors.newFixedThreadPool(16);	
					long currentTime = System.nanoTime();
					for (User user : users) {
						executor.execute(user);		//execute each user
					}
					
					executor.shutdown();
					
					while(!executor.isTerminated()){
//						try{
//							Thread.sleep(100);
//						}
//						catch(InterruptedException e){
//							e.printStackTrace();
//						}
					}
					

					long endTime = System.nanoTime();

//					 for (User user : users) {							//Use this to get the ending balance for each account after each run.
	//					 System.out.println(user.getAccount().getAccountNumber() +
	//					 " - "
	//					 + user.getAccount().getBalance());
//					 }
					time[i] = endTime - currentTime;
//					System.out.println("finished run " + i);
				}
				long sum = 0;
				for (int i = 1; i < time.length; i++) { // add up all the times but drop the first one which is an outlier
					sum+=time[i];
				}
				long avg = sum/9;
				System.out.print(avg+"\t");
//				System.out.println("Time profile");
//				for (int i = 0; i < time.length; i++) {
//					System.out.println(i + "\t" + time[i]);
//				}
			}
			System.out.print("\n");
		}

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
				pw.println(i + " " + (int) (Math.random() * 100000) + ".00");
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
			PrintWriter pw = new PrintWriter("actions" + numActions);
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
