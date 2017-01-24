
/**
 * <h1>Employee</h1> Employee object used to store his/her name and id.
 * 
 * @author Sotheanith Sok
 * @since 11-7-2016
 * @version 1.0
 */
public class Employee implements Comparable<Employee> {

	/** The first name of the employee */
	private String fName;

	/** The last name of the employee */
	private String lName;

	/** The id of the employee */
	private int id;

	/**
	 * Instantiates a new employee with user given values.
	 *
	 * @param fName the first name
	 * @param lName the last name
	 * @param id the id
	 */
	public Employee(String fName, String lName, int id) {
		this.fName = fName;
		this.lName = lName;
		this.id = id;
	}

	/**
	 * This method is used to get the first name
	 * 
	 * @return first name.
	 */
	public String getFirstName() {
		return fName;
	}

	/**
	 * This method is used to get the last name.
	 * 
	 * @return last name.
	 */
	public String getLastName() {
		return lName;
	}
	
	/**
	 * This method is used to get the ID.
	 * @return id.
	 */
	public int getID() {
		return id;
	}

	/**
	 * This method is used to calculate hashCode for this object.
	 * 
	 * @return hashCode of Employee object.
	 */
	public int hashCode() {
		final int HASH_MULTIPLIER = 29;
		int h = HASH_MULTIPLIER * fName.hashCode() + lName.hashCode();
		h = HASH_MULTIPLIER * h + ((Integer) id).hashCode();
		return h;
	}

	/**
	 * This method is used to find the Employees' Name.
	 * 
	 * @return Employee full name
	 */
	public String toString() {
		return lName + ", " + fName;
	}

	/**
	 * This is an implementation of comparable used to sorted employee by name.
	 * 
	 * @return position number if this employee come before employee o, negative
	 *         if this employee come after employee o, else 0 if this employee
	 *         and o employee are the same.
	 */
	@Override
	public int compareTo(Employee o) {
		if(lName.compareToIgnoreCase(o.getLastName())!=0){
			return lName.compareToIgnoreCase(o.getLastName());
		}else if(fName.compareToIgnoreCase(o.getFirstName())!=0){
			return fName.compareToIgnoreCase(o.getFirstName());
		}else{
			return Integer.compare(id, o.getID());
		}
	}
}
