package Implementation_2_EventListenerInAnInncerClassWithThePanel;

/**
 * <h1>BankAccount</h1> A bank account has a balance that can be changed by
 * deposits and withdrawals.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 12-03-2016
 */

public class BankAccount implements Comparable<BankAccount> {

	/** The balance. */
	private double balance;

	/**
	 * Constructs a bank account with a zero balance.
	 */
	public BankAccount() {
		balance = 0;
	}

	/**
	 * Constructs a bank account with a given balance.
	 * 
	 * @param initialBalance the initial balance
	 */
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}

	/**
	 * Deposits money into the bank account.
	 * 
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount) {
		if (amount < 0) {
			throw new NumberFormatException();
		}
		double newBalance = balance + amount;
		balance = newBalance;
	}

	/**
	 * Withdraws money from the bank account.
	 * 
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {
		if (amount > balance || amount < 0) {
			throw new NumberFormatException();
		}
		double newBalance = balance - amount;
		balance = newBalance;
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
	 * Use to compare this object to another object of the same type based on
	 * balance.
	 * 
	 * @return -1 if this object is less than another object, 1 if this object
	 *         is larger than another object, else return 0.
	 */
	public int compareTo(BankAccount other) {
		double d = balance - other.balance;
		if (d < 0)
			return -1;
		if (d > 0)
			return 1;
		return 0;
	}
}