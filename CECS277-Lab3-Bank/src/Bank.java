import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * <h1>Bank</h1> A bank contains account numbers and balances of each customer.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-09-26
 */
public class Bank {

	/** The account list. */
	private ArrayList<BankAccount> accountList;

	/**
	 * Construct a Bank object.
	 */
	public Bank() {
		accountList = new ArrayList<BankAccount>();
	}

	/**
	 * Reads a file with account numbers and balances and adds the accounts to
	 * the bank.
	 *
	 * @param filename the name of the file
	 */
	public void readFile(String filename) throws IOException {
		File reader = new File(filename);
		Scanner in = new Scanner(reader);
		try {
			read(in);
		} finally {
			in.close();
		}
	}

	/**
	 * Read a file with account numbers and balances and adds the accounts to
	 * the bank.
	 *
	 * @param in the scanner for reading the input
	 */
	private void read(Scanner in) throws IOException {
		while (in.hasNext()) {
			BankAccount bankAcc = new BankAccount();
			bankAcc.read(in);
			accountList.add(bankAcc);
		}
	}

	/**
	 * Add an account to the bank.
	 *
	 * @param b the BankAccount reference
	 */
	public void addBankAccount(BankAccount b) {
		accountList.add(b);
	}

	/**
	 * Gets the account with the highest balance.
	 *
	 * @return the account with the highest balance
	 */
	public BankAccount getHighestBalance() {
		BankAccount b = accountList.get(0);
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getBalance() > b.getBalance()) {
				b = accountList.get(i);
			}
		}
		return b;
	}
}
