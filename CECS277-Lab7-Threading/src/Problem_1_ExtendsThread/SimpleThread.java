package Problem_1_ExtendsThread;
/**
 * <h1>SimpleThread</h1> This object is used to test thread running and pausing
 * at random interval.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 11-28-2016
 */

public class SimpleThread extends Thread {

	/** The count keeps track on how many time has a thread ran. */
	private int count;

	/** The phrase the phrase that needed to be print. */
	private String phrase;

	/**
	 * Instantiates a new simple thread and initialize the count and phrase.
	 *
	 * @param s the phrase that needed to be print.
	 */
	public SimpleThread(String s) {
		phrase = s;
		count = 0;
	}
	/**
	 * The logic by which the thread should be run
	 */
	@Override
	public void run() {
		try {
			while (count < 10) {
				System.out.println(count + " " + phrase);
				count++;
				Thread.sleep((int) (Math.random() * 1000));
			}
			System.out.println("Done! " + phrase);
		} catch (InterruptedException e) {
			System.err.println("Thread interruped!!!");
		}

	}

}
