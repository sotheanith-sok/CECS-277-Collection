package Implementation_2_EventListenerInAnInncerClassWithThePanel;

import java.awt.*;
import javax.swing.*;

/**
 * <h1>BankAccountFrame</h1> A Bank Account Frame used to adjust the setting for
 * the frame.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 12-03-2016
 */
public class BankAccountFrame extends JFrame {
	
	/**
	 * Instantiates a new bank account frame.
	 *
	 * @param account the bank account
	 */
	public BankAccountFrame(BankAccount account) {
		setTitle("Bank Account 2");
		setSize(500, 200);
		centerWindow(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new BankAccountPanel(account);
		this.add(panel);
	}

	/**
	 * Center the frame in the middle of the screen.
	 *
	 * @param w the window
	 */
	private void centerWindow(Window w) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setLocation((d.width - w.getWidth()) / 2, (d.height - w.getHeight()) / 2);
	}
}
