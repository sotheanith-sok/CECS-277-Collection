import java.util.Scanner;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * <h1>BankAccount</h1> A bank account has a balance that can be changed by
 * deposits and withdrawals.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-09-26
 */
public class BankAccount {

	/** The balance. */
	private double balance;

	/** The account number. */
	private int accountNumber;

	/**
	 * Constructs a bank account with a zero balance.
	 */
	public BankAccount() {
		balance = 0;
		accountNumber = 0;
	}

	/**
	 * Constructs a bank account with a given account number and a initial
	 * balance.
	 *
	 * @param balance the balance
	 * @param accountNumber the account number
	 */
	public BankAccount(double balance, int accountNumber) {
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	/**
	 * Reads an account number and balance.
	 *
	 * @param in the scanner
	 * @return true if the data was read. false if the end of the stream was
	 *         reached.
	 */
	public void read(Scanner in) throws IOException {
		try {
			accountNumber = in.nextInt();
			balance = in.nextDouble();
		} catch (NoSuchElementException nsee) {
			throw new IOException();
		}
	}

	/**
	 * Deposits money into the bank account.
	 *
	 * @param amount the amount to deposit
	 */
	public void depositsMoney(double amount) {
		balance += amount;
	}

	/**
	 * Withdraws money from the bank account.
	 *
	 * @param amount the amount to withdraw
	 */
	public void withdrawMoney(double amount) {
		if (amount > balance) {
			System.out.println("Insufficient funds.");
		} else {
			balance -= amount;
		}
	}

	/**
	 * Gets the current balance of the bank account.
	 *
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Gets the account number of the bank account.
	 *
	 * @return the account number
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
}
