package Problem_1_ExtendsThread;
/**
 * <h1>TwoThreadsDemo</h1> This is a tester used to test SimpleThread.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 11-28-2016
 */

public class TwoThreadsDemo {

	public static void main(String[] args) {
		new SimpleThread("CECS 277").start();
		new SimpleThread("OOP in Java").start();
	}

}
