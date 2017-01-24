package Implementation_1_EventListenerInASeperateClass;

import javax.swing.JFrame;

/**
 * <h1>BankAccountViewer</h1> A GUI for manipulating a bank account.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 12-03-2016
 */
public class BankAccountViewer {

	/** The Constant INITIAL_BALANCE of 1000. */
	private static final double INITIAL_BALANCE = 1000;

	public static void main(String[] args) {
		BankAccount account = new BankAccount(INITIAL_BALANCE);

		// construct the frame
		JFrame frame = new BankAccountFrame(account);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
