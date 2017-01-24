/**
 * <h1>Faculty</h1> This object class contains data members and methods
 * necessary for storing and calculating information related to the faculty.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-09-19
 */
public class Faculty extends Employee implements EmployeeInfo, Cloneable {

	/** The position of the faculty. */
	private Level level;

	/** Informations about the education of the faculty. */
	private Education edu;

	/**
	 * This enum method listed all available positions of the faculty.
	 */
	public enum Level {

		/** The Unknown. */
		Unknown,
		/** The as. */
		AS,
		/** The ao. */
		AO,
		/** The fu. */
		FU
	}

	/**
	 * This is the default constructor used to initialize data members.
	 */
	public Faculty() {
		super();
		edu = new Education();
		level = Level.Unknown;
	}

	/**
	 * This constructor is used to initialize data members with input values.
	 *
	 * @param lastName
	 *            the last name
	 * @param firstName
	 *            the first name
	 * @param id
	 *            the id
	 * @param sex
	 *            the sex
	 * @param date
	 *            the date
	 * @param month
	 *            the month
	 * @param year
	 *            the year
	 * @param degree
	 *            the degree
	 * @param major
	 *            the major
	 * @param research
	 *            the research
	 * @param level
	 *            the level
	 */
	public Faculty(String lastName, String firstName, String id, char sex, int date, int month, int year, String degree,
			String major, int research, Level level) {
		super(lastName, firstName, id, sex, date, month, year);
		edu = new Education(degree, major, research);
		this.level = level;

	}

	/**
	 * This method is used to access the level.
	 *
	 * @return The level
	 */
	public Level getLeve() {
		return level;
	}

	/**
	 * This method is used to access the Education object.
	 *
	 * @return The Education object
	 */
	public Education getEducation() {
		return edu;
	}

	/**
	 * This method is used to mutate the level.
	 *
	 * @param level
	 *            the new level
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * This method is used to mutate the Education object.
	 *
	 * @param edu
	 *            the new education
	 */
	public void setEducation(Education edu) {
		this.edu = edu;
	}

	/**
	 * This method is used to calculate the monthly earning.
	 *
	 * @return The monthly earning
	 */
	public double monthlyEarning() {
		if (level == Level.AS) {
			return facultyMonthlySalary;
		} else if (level == Level.AO) {
			return facultyMonthlySalary * 1.2;
		} else if (level == Level.FU) {
			return facultyMonthlySalary * 1.4;
		} else {
			return 0;
		}
	}

	/**
	 * This method is used to find the string representation of the Faculty
	 * object.
	 *
	 * @return The Faculty object in string form
	 */
	public String toString() {
		return super.toString() + "Level: " + level + "\nDegree: " + edu.getDegree() + "\nMajor: " + edu.getMajor()
				+ "\nResearch: " + edu.getResearch() + "\nMonthly Salary: " + monthlyEarning();
	}

	/**
	 * This method is used to deep copy a Faculty object.
	 *
	 * @return The cloned object
	 * @throws CloneNotSupportedException
	 *             the clone not supported exception
	 */
	public Object clone() throws CloneNotSupportedException {
		Faculty f = (Faculty) super.clone();
		edu = (Education) edu.clone();
		return f;
	}

}
