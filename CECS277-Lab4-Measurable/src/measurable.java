import java.util.ArrayList;

/**
 * <h1>measurable</h1> measurable is an abstract class used to get value and
 * find the largest value in an arraylist .
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-10-16
 *
 */
public abstract class measurable {

	/**
	 * This function is used to get the value from the measurable object
	 *
	 * @return the measurable value
	 */
	public abstract double getMeasure();

	/**
	 * This function is used to find the largest value in an arraylist
	 *
	 * @param obj the arraylist of value
	 * @return the largest value
	 */
	public static <T extends measurable> T largest(ArrayList<T> obj) {
		T v = obj.get(0);
		for (T x : obj) {
			if (v.getMeasure() < x.getMeasure()) {
				v = x;
			}
		}
		return v;
	}
}
