import java.util.Calendar;

/**
 * <h1>PartTime</h1> This object class contain data members and methods necessary
 * in storing and calculating information related to the part-time employees.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-09-16
 */
public class PartTime extends Staff {
	
	/** The number of hours by which the part-time employee worked per week. */
	private double hoursWorkedPerWeek;

	/**
	 * This is a default constructor used to initialize data members.
	 */
	public PartTime() {
		super();
		hoursWorkedPerWeek = 0;
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
	 * @param hoursWorkedPerWeek the hours worked per week
	 */
	public PartTime(String lastName, String firstName, String id, char sex, int date, int month, int year,
			double hourlyRate, double hoursWorkedPerWeek) {
		super(lastName, firstName, id, sex, date, month, year, hourlyRate);
		this.hoursWorkedPerWeek = hoursWorkedPerWeek;
	}

	/**
	 * This method is used to access the hours worked per week of the employee.
	 *
	 * @return The hours worked per week
	 */
	public double getHoursWorkedPerWeek() {
		return hoursWorkedPerWeek;
	}

	/**
	 * This method is used to mutate the hours worked per week of the employee.
	 *
	 * @param hoursWorkedPerWeek the new hours worked per week
	 */
	public void setHoursWorkedPerWeek(double hoursWorkedPerWeek) {
		this.hoursWorkedPerWeek = hoursWorkedPerWeek;
	}

	/**
	 * This method is used to calculate the monthly earning of the employee.
	 *
	 * @return The monthly earning
	 */
	public double monthlyEarning() {
		return super.getHourlyRate() * hoursWorkedPerWeek * 4;
	}

	/**
	 * This method is used to find the string representation of the part-time
	 * employee object.
	 *
	 * @return The string representation of the Part-Time employee object
	 */

	public String toString() {
		String s = super.toString();
		int i = s.indexOf("Full") - 1;
		s = s.substring(0, i);
		return s + "\nHours works per month: " + hoursWorkedPerWeek * 4 + "\nMonthly Salary: " + monthlyEarning();
	}

}
