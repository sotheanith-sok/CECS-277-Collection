package Implementation_1_EventListenerInASeperateClass;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * <h1>BankAccountPanel</h1> A Bank Account Panel used to set the layout of the
 * frame. It implements ActionListener in a seperate class.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 12-03-2016
 */
public class BankAccountPanel extends JPanel {

	/** The output text field, The input text field. */
	public JTextField inputTextField, outputTextField;

	/** The amount label, The balance label. */
	private JLabel amountLabel, balanceLabel;

	/** The withdraw button, The deposit button. */
	public JButton withdrawButton, depositButton;

	/**
	 * Instantiates a new bank account panel.
	 *
	 * @param account the bank account
	 */
	public BankAccountPanel(BankAccount account) {

		ActionListener listener = new BankAccountPanelActionListener(this, account);
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
		withdrawButton.addActionListener(listener);
		depositButton = new JButton("Deposit");
		depositButton.addActionListener(listener);

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
