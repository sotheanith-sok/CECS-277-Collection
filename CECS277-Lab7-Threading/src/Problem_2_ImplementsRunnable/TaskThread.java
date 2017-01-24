package Problem_2_ImplementsRunnable;
/**
 * <h1>TaskThread</h1> This object is used to test thread running and pausing
 * at random interval which doing some task.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 11-28-2016
 */

public class TaskThread implements Runnable {
	
	/** The task number is index of current task. */
	private int taskNumber;

	/**
	 * Instantiates a new task thread with given task index.
	 *
	 * @param number the index of current task.
	 */
	public TaskThread(int number) {
		taskNumber = number;
	}

	/**
	 * The logic by which the thread should be run
	 */
	public void run() {
		for (int i = 0; i <= 100; i += 20) {
			// Perform some task...
			System.out.println("Task number: " + taskNumber + ", percent complete: " + i);
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				System.err.println("Thread interruped!!!");
			}
		}
	}
}
