import java.util.*;

/**
 * <h1>LotteryMachine</h1> This program is used to simulate a lottery machine.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-10-31
 */
public class LotteryMachine {
	public static void main(String[] args) {
		int choice;
		Scanner in = new Scanner(System.in);
		do {
			choice = menu(in);
			switch (choice) {
			case 1:
				System.out.println("-Playing-");
				Set<Integer> win = generateWinningNumbers();
				Set<Integer> player = getTicket();
				Set<Integer> match = new HashSet<Integer>();
				Iterator<Integer> it = player.iterator();
				int count = 0;
				while (it.hasNext()) {
					int i = it.next();
					if (win.contains(i)) {
						match.add(i);
						count++;
					}
				}
				System.out.println("Your ticket was: " + player);
				System.out.println("Winning numbers: " + win);
				System.out.println("Match numbers: " + match);
				System.out.println("Your prize is $" + 250 * count);
				break;
			case 2:
				System.out.println("-Exiting-");
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
		} while (choice != 2);
	}

	/**
	 * This function is used to generate 6 winning numbers between 1 and 40
	 *
	 * @return the sets contains winning numbers
	 */
	public static Set<Integer> generateWinningNumbers() {
		Set<Integer> temp = new HashSet<Integer>(6);
		for (int i = 0; i < 6;) {
			boolean add = temp.add((int) (Math.random() * 40) + 1);
			if (add == true) {
				i++;
			}
		}
		return temp;
	}

	/**
	 * This function is used to get the user lottery numbers
	 *
	 * @return the ticket contains 6 numbers
	 */
	public static Set<Integer> getTicket() {
		Set<Integer> temp = new HashSet<Integer>(6);
		Scanner in = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			try {
				System.out.print("Type 6 lotto numbers: ");
				String input = in.nextLine();
				String[] stringArray = input.split(" ");
				if (stringArray.length != 6) {
					throw new InputMismatchException("Invalid quantity of lotto numbers.");
				}
				for (int i = 0; i < stringArray.length; i++) {
					stringArray[i] = stringArray[i].trim();
				}
				for (int i = 0; i < stringArray.length;) {
					boolean add = true;
					try {
						if (Integer.parseInt(stringArray[i]) < 1 || Integer.parseInt(stringArray[i]) > 40)
							throw new NumberFormatException();
						add = temp.add(Integer.parseInt(stringArray[i]));
					} catch (NumberFormatException nfe) {
						throw new InputMismatchException("Invalid Input");
					}
					if (add == true) {
						i++;
					} else {
						temp.clear();
						throw new InputMismatchException("Duplicated lotto numbers detected.");
					}
				}
				done = true;
			} catch (InputMismatchException ime) {
				System.out.println(ime.getMessage() + " Please try again.");
			}
		}
		return temp;
	}

	/**
	 * This function is used to print out the menu and get user's input
	 *
	 * @param in the keyboard scanner
	 * @return the valid user choice
	 */
	public static int menu(Scanner in) {
		boolean done = false;
		int choice = 0;
		while (!done) {
			System.out.println("1. Play");
			System.out.println("2. Exit");
			try {
				choice = in.nextInt();
				if (choice != 1 && choice != 2) {
					throw new InputMismatchException();
				}
				done = true;
			} catch (InputMismatchException ime) {
				System.out.println("Invalid Input. Please try again.");
				in.nextLine();
			}
		}
		return choice;
	}
}
