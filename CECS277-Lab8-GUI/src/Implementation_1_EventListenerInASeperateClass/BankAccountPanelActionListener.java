package Implementation_1_EventListenerInASeperateClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <h1>BankAccountPanelActionListener</h1> Implementation of ActionListner in a
 * separate class.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 12-03-2016
 */
public class BankAccountPanelActionListener implements ActionListener {

	/** The Bank Account Panel. */
	private BankAccountPanel panel;

	/** The Bank Account. */
	private BankAccount account;

	/**
	 * Instantiates a new bank account panel action listener.
	 *
	 * @param p the Bank Account Panel.
	 * @param b the Bank Account.
	 */
	public BankAccountPanelActionListener(BankAccountPanel p, BankAccount b) {
		this.panel = p;
		account = b;
	}

	/**
	 * This is an implementation of ActionListener.
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		try {
			if (source == panel.depositButton) {
				account.deposit(Double.parseDouble(panel.inputTextField.getText()));
			} else if (source == panel.withdrawButton) {
				account.withdraw(Double.parseDouble(panel.inputTextField.getText()));
			}
			panel.outputTextField.setText(Double.toString(account.getBalance()));
		} catch (NumberFormatException nfe) {
			panel.inputTextField.setText("Invalid Input");
		}

	}

}
