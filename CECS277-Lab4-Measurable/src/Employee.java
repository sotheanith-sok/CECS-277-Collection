/**
 * 
 * <h1>Employee</h1> Employee contains information related to an employee. *
 * 
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-10-17
 */
public class Employee implements Comparable<Employee> {

	/**
	 * fName= first name of employee
	 * 
	 */
	private final String fName;

	/**
	 * lName=last name of employee
	 * 
	 */
	private final String lName;

	/**
	 * The id= identification number of employee
	 *
	 */
	private final Integer id;

	/**
	 * Instantiates a new employee object with given values.
	 *
	 * @param f the first name
	 * @param l the last name
	 * @param i the id
	 */
	public Employee(String f, String l, int i) {
		fName = f;
		lName = l;
		id = i;
	}

	/**
	 * Gets the first name of employee.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return fName;
	}

	/**
	 * Gets the last name of employee.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lName;
	}

	/**
	 * Gets the id of employee.
	 *
	 * @return the id
	 */
	public int getID() {
		return id;
	}

	/**
	 * This is an implementation Comparable used to compare Employee object by
	 * first name
	 * 
	 * @return number<0 if this object is come before o object, number>0 if o
	 *         object comes before this object; else 0
	 */
	public int compareTo(Employee o) {
		return fName.compareTo(o.getFirstName());
	}

	/**
	 * This function is used to find a string representation of this object
	 * 
	 * @return a employee string
	 */
	public String toString() {
		return String.format("%-10s %-10s %-10d", fName, lName, id);

	}

}
