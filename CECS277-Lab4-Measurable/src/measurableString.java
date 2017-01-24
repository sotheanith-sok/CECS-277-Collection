/**
 * *
 * <h1>measurableString</h1> measurableString is an object used to store and
 * find the length of string.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-10-16
 */
public class measurableString extends measurable {

	/**
	 * The value contains the string
	 * 
	 */
	private final String value;

	/**
	 * This constructor is used to initialize the value of string
	 *
	 * @param s the s
	 */
	public measurableString(String s) {
		value = s;
	}

	/**
	 * This function is used to find the length of the string
	 * 
	 * @return the length of string
	 */
	public double getMeasure() {
		return (double) value.length();
	}

	/**
	 * This function is used to return the string representation of this object
	 */
	public String toString() {
		return value;
	}
}
