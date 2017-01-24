import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * <h1>BankReader</h1> Reads bank accounts from a file and prints highest
 * balance.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-09-26
 */
public class BankReader {

	/**
	 * Prompts for and reads name of file to process.
	 *
	 * @param in Scanner from which to read
	 * @return the file name
	 */
	private static String getFileName(Scanner in) {
		String filename = null;
		System.out.println("Enter file to process:");
		if (in.hasNext()) {
			filename = in.next();
		}
		return filename;
	}

	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner in = new Scanner(System.in);
		String filename = getFileName(in);
		boolean done = false;
		while (!done) {
			try {
				bank.readFile(filename);
				System.out.println("-Highest Balance-\n " + "Account Number: "+bank.getHighestBalance().getAccountNumber() + "     Balance: "
						+ bank.getHighestBalance().getBalance());
				done = true;
			} catch (FileNotFoundException fnf) {
				System.err.println(filename + " not found");
				filename = getFileName(in);
			} catch (IOException e) {
				System.err.println(filename + " contains improperly formatted line");
				filename = getFileName(in);
			}
		}
	}
}
