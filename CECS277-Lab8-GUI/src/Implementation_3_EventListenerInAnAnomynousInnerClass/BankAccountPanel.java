package Implementation_3_EventListenerInAnAnomynousInnerClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * <h1>BankAccountPanel</h1> A Bank Account Panel used to set the layout of the
 * frame. It implements ActionListener in an anomynous inner class.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 12-03-2016
 */
public class BankAccountPanel extends JPanel {

	/** The input text field, The output text field. */
	private JTextField inputTextField, outputTextField;

	/** The amount label, The balance label. */
	private JLabel amountLabel, balanceLabel;

	/** The withdraw button, The deposit button. */
	private JButton withdrawButton, depositButton;

	/** The account. */
	private BankAccount account;

	/**
	 * Instantiates a new bank account panel.
	 *
	 * @param account the bank account
	 */
	public BankAccountPanel(BankAccount account) {
		this.account = account;

		// display panel
		this.setLayout(new BorderLayout());
		JPanel displayPanel0 = new JPanel();
		JPanel displayPanel1 = new JPanel();

		// Text field
		inputTextField = new JTextField(10);
		outputTextField = new JTextField(10);
		outputTextField.setEditable(false);
		outputTextField.setText(Double.toString(account.getBalance()));

		// Label
		amountLabel = new JLabel("Amount:");
		balanceLabel = new JLabel("Balance");

		// Buttons
		withdrawButton = new JButton("Withdraw");
		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					account.withdraw(Double.parseDouble(inputTextField.getText()));
					outputTextField.setText(Double.toString(account.getBalance()));
				} catch (NumberFormatException nfe) {
					inputTextField.setText("Invalid Input");
				}
			}
		});
		depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					account.deposit(Double.parseDouble(inputTextField.getText()));
					outputTextField.setText(Double.toString(account.getBalance()));
				} catch (NumberFormatException nfe) {
					inputTextField.setText("Invalid Input");
				}
			}
		});

		// Adds all label, button, and text field into panels
		displayPanel0.add(amountLabel);
		displayPanel0.add(inputTextField);
		displayPanel0.add(withdrawButton);
		displayPanel0.add(depositButton);
		displayPanel1.add(balanceLabel);
		displayPanel1.add(outputTextField);

		// Set layout for both panel
		displayPanel0.setLayout(new FlowLayout());
		displayPanel1.setLayout(new FlowLayout());
		this.add(displayPanel0, BorderLayout.NORTH);
		this.add(displayPanel1, BorderLayout.SOUTH);

	}
}
