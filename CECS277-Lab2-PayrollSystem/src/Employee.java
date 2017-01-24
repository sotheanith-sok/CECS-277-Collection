import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 * <h1>Employee</h1> Employee is an abstract class contains data members and
 * methods which used to create sub classes.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-09-14
 */
public abstract class Employee implements Comparable<Employee>, Cloneable {
	
	/** Last name of the employee. */
	private String lastName;
	
	/** First name of the employee. */
	private String firstName;
	
	/** ID number of the employee. */
	private String id;
	
	/** Gender of the employee. */
	private char sex;
	
	/** Date of birth of the employee. */
	private Calendar dob;

	/**
	 * This constructor used to initialize data members.
	 */
	public Employee() {
		lastName = "Unknown";
		firstName = "Unknown";
		id = "Unknown";
		sex = 'U';
		dob = null;
	}

	/**
	 * This constructor used to initialize data members with input values.
	 *
	 * @param lastName the last name
	 * @param firstName the first name
	 * @param id the id
	 * @param sex the sex
	 * @param date the date
	 * @param month the month
	 * @param year the year
	 */
	public Employee(String lastName, String firstName, String id, char sex, int date, int month, int year) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
		this.sex = sex;
		dob = new GregorianCalendar();
		dob.set(year, month, date);
	}

	/**
	 * This method is used to return a string representation of Employee object.
	 *
	 * @return Employee in string form
	 */
	public String toString() {
		String s = "";
		s = "ID Employee number: " + id + "\n" + "Employee Name: " + firstName + " " + lastName + "\n" + "Birth Date: "
				+ dob.get(Calendar.MONTH) + "/" + dob.get(Calendar.DAY_OF_MONTH) + "/" + dob.get(Calendar.YEAR) + "\n";
		return s;
	}

	/**
	 * This method is used to access the last name.
	 *
	 * @return Last name
	 */
	public final String getLastName() {
		return lastName;
	}

	/**
	 * This method is used to access the first name.
	 *
	 * @return First name
	 */
	public final String getFirstName() {
		return firstName;
	}

	/**
	 * This method is used to access the ID.
	 *
	 * @return ID number
	 */
	public final String getID() {
		return id;
	}

	/**
	 * This method is used to access the gender.
	 *
	 * @return Gender
	 */
	public final char getSex() {
		return sex;
	}

	/**
	 * This method is used to access the DateOfBirth object.
	 *
	 * @return The DateOfBirth object
	 */
	public final Calendar getDateOfBirth() {
		return dob;
	}

	/**
	 * This method is used to mutate the last name.
	 *
	 * @param lastName the new last name
	 */
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * This method is used to mutate the first name.
	 *
	 * @param firstName the new first name
	 */
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This method is used to mutate the ID number.
	 *
	 * @param id the new id
	 */
	public final void setID(String id) {
		this.id = id;
	}

	/**
	 * This method is used to mutate the gender.
	 *
	 * @param sex the new sex
	 */
	public final void setSex(char sex) {
		this.sex = sex;
	}

	/**
	 * This method is used to mutate the date of birth.
	 *
	 * @param dob the new date of birth
	 */
	public final void setDateOfBirth(Calendar dob) {
		this.dob = dob;
	}

	/**
	 * This method is the implementation of the Comparable used to compare by ID
	 * number.
	 *
	 * @param object the object
	 * @return Integer value that represent the order by which the two ID numbers relate
	 */
	public int compareTo(Employee object) {
		return object.getID().compareToIgnoreCase(id);
	}

	/**
	 * This method is the implementation of the Comparator used to compare by
	 * last name.
	 *
	 * @return Integer value that represent the order by which the two last names
	 *         relate
	 */
	public static Comparator<Employee> lastNameComparator = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {
			return e1.getLastName().compareTo(e2.getLastName());
		}
	};

	/**
	 * This method is used to shallow copy an object.
	 *
	 * @return The cloned object
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * This a prototype method used to calculate the monthly earning.
	 *
	 * @return the monthly earning
	 */
	public abstract double monthlyEarning();	
}