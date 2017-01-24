package Problem_2_ImplementsRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <h1>TaskThreadDemo</h1> This is a tester used to run the thread created by
 * TaskThread by using two threads with two threads.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 11-28-2016
 */

public class TaskThreadDemo {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newFixedThreadPool(2);
		executor.execute(new TaskThread(0));
		executor.execute(new TaskThread(1));
		executor.execute(new TaskThread(2));	
		executor.execute(new TaskThread(3));	
		executor.shutdown();
	}
}
