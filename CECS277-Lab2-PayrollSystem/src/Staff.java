import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * <h1>Staff</h1> This object class contains data members and methods necessary
 * in storing and calculating information related to full-time employee.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-09-16
 */
public class Staff extends Employee implements EmployeeInfo {
	
	/** The hourly paid rate of the employee. */
	private double hourlyRate;

	/**
	 * This default constructor is used to initialize date member.
	 */
	public Staff() {
		super();
		hourlyRate = 0;
	}

	/**
	 * This constructor is used to initialize data members with given values.
	 *
	 * @param lastName the last name
	 * @param firstName the first name
	 * @param id the id
	 * @param sex the sex
	 * @param date the date
	 * @param month the month
	 * @param year the year
	 * @param hourlyRate the hourly rate
	 */
	public Staff(String lastName, String firstName, String id, char sex, int date, int month, int year,
			double hourlyRate) {
		super(lastName, firstName, id, sex, date, month, year);
		this.hourlyRate = hourlyRate;
	}

	/**
	 * This method is used to access hourly paid rate.
	 *
	 * @return The hourly paid rate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * This method is used to mutate hourly paid rate.
	 *
	 * @param hourlyRate the new hourly rate
	 */
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	/**
	 * This method is used to calculate the monthly earning.
	 *
	 * @return The monthly earning of the employee
	 */
	public double monthlyEarning() {
		return hourlyRate * staffMonthlyHoursWorked;
	}

	/**
	 * This method is used to calculate a string representation of this object.
	 *
	 * @return The string representation of Staff object
	 */
	public String toString() {
		String s = super.toString();
		return super.toString() + "Full Time\n" + "Monthly Salary: " + monthlyEarning();
	}
}
