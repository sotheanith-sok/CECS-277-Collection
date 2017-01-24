/**
 * <h1>Education</h1> Education is the object class contains informations of the
 * education of the faculty.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-09-14
 */
public class Education implements Cloneable {
	
	/** The degree in which the faculty obtained. */
	private String degree;
	
	/** The major of the faculty. */
	private String major;
	
	/** The number of research faculty has done. */
	private int research;

	/**
	 * This is a default constructor used to initialize data members.
	 */
	public Education() {
		degree = "Unknown";
		major = "Unknown";
		research = 0;
	}

	/**
	 * This constructor used to initialize data members with given values.
	 *
	 * @param degree the degree
	 * @param major the major
	 * @param research the research
	 */
	public Education(String degree, String major, int research) {
		this.degree = degree;
		this.major = major;
		this.research = research;
	}

	/**
	 * This method is used to access faculty's degree.
	 *
	 * @return The degree of the faculty
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * This method is used to access faculty's major.
	 *
	 * @return The major of the faculty
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * This method is used to access faculty's research count.
	 *
	 * @return The number of research done by the faculty
	 */
	public int getResearch() {
		return research;
	}

	/**
	 * This method is used to mutate facutly's degree.
	 *
	 * @param degree the new degree
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * This method is used to mutate facutly's major.
	 *
	 * @param major the new major
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * This method is used to mutate facutly's research count.
	 *
	 * @param research the new research
	 */
	public void setResearch(int research) {
		this.research = research;
	}

	/**
	 * This method is used to shallow copy object.
	 *
	 * @return The cloned object
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
