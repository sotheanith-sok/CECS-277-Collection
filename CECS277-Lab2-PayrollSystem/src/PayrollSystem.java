import java.util.*;
import java.io.*;

/**
 * <h1>The Payroll System</h1> This payroll system contains information related
 * to all employee.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-09-16
 */
public class PayrollSystem {

	public static void main(String[] args) {
		Employee[] list = new Employee[9];
		list[0] = new Staff("Allen", "Paita", "123", 'M', 23, 2, 59, 50);
		list[1] = new Staff("Zapata", "Steven", "456", 'F', 12, 7, 64, 35);
		list[2] = new Staff("Rios", "Enrique", "789", 'M', 2, 6, 70, 40);
		list[3] = new Faculty("Johnson", "Anee", "243", 'F', 27, 4, 62, "Ph.D", "Enginerring", 3, Faculty.Level.FU);
		list[4] = new Faculty("Bouris", "William", "791", 'F', 14, 3, 75, "Ph.D", "English", 1, Faculty.Level.AO);
		list[5] = new Faculty("Andrade", "Christopher", "623", 'F', 22, 5, 80, "MS", "Physical Education", 0,
				Faculty.Level.AS);
		list[6] = new PartTime("Guzman", "Augusto", "455", 'F', 10, 8, 77, 35, 30);
		list[7] = new PartTime("Depirro", "Martin", "678", 'F', 15, 9, 87, 30, 15);
		list[8] = new PartTime("Aldaco", "Marque", "945", 'M', 24, 11, 88, 20, 35);
		Scanner in = new Scanner(System.in);
		String input = null;
		do {
			menu();
			input = in.nextLine();
			switch (input) {
			case "1":
				System.out.println("-Employee List-");
				displayEmployeeInfo(list);
				break;
			case "2":
				System.out.println("-Total Monthly Salary For Part-Time Employees-");
				totalMonthlySalaryForPartTime(list);
				break;
			case "3":
				System.out.println("-Total Monthly Salary For All Employees-");
				totalMonthlySalaryForEmployees(list);
				break;
			case "4":
				System.out.println("-Employee Sorted By ID-");
				employeeSortedByID(list);
				break;
			case "5":
				System.out.println("-Employee Sorted By Last Name-");
				employeeSortedByLastName(list);
				break;
			case "6":
				System.out.println("-Clone Verification-");
				cloneVerification(list);
				break;
			case "7":
				System.out.println("-Exiting-");
				break;
			default:
				System.out.println("-Invalid Input. Try again.-");
				break;
			}

		} while (input.compareTo("7") != 0);

	}

	/**
	 * This method is used to display the available option.
	 */

	public static void menu() {
		System.out.println("1. Employee Information");
		System.out.println("2. Total monthly salary for all part-time staff");
		System.out.println("3. Total monthly salary for all employees");
		System.out.println("4. Employee Info sorted by ID");
		System.out.println("5. Employee Info sorted by Last Name");
		System.out.println("6. Clone verification");
		System.out.println("7. Exit");

	}

	/**
	 * This method is used to display employees' information divided by their
	 * types.
	 *
	 * @param list the list of employees
	 */
	public static void displayEmployeeInfo(Employee[] list) {
		System.out.println("-Staff-");
		for (int i = 0; i < list.length; i++) {
			if (list[i] instanceof Staff && !(list[i] instanceof PartTime)) {
				System.out.println(list[i] + "\n");
			}
		}
		System.out.println("-Faculty-");
		for (int i = 0; i < list.length; i++) {
			if (list[i] instanceof Faculty) {
				System.out.println(list[i] + "\n");
			}
		}
		System.out.println("-Part-Time-");
		for (int i = 0; i < list.length; i++) {
			if (list[i] instanceof PartTime) {
				System.out.println(list[i] + "\n");
			}
		}
	}

	/**
	 * This method is used to calculate the total monthly salary of all
	 * part-time employees.
	 *
	 * @param list the list of employees
	 */
	public static void totalMonthlySalaryForPartTime(Employee[] list) {
		double total = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] instanceof PartTime) {
				total += list[i].monthlyEarning();
			}
		}
		System.out.println("Total monthly salary for all part-time staffs: " + total);
	}

	/**
	 * This method is used to calculate the total monthly salary of all
	 * employees.
	 *
	 * @param list the list of employees
	 */
	public static void totalMonthlySalaryForEmployees(Employee[] list) {
		double total = 0;
		for (int i = 0; i < list.length; i++) {
			total += list[i].monthlyEarning();
		}
		System.out.println("Total monthly salary for all employee: " + total);
	}

	/**
	 * This method is used to display employees' information sorted by their ID
	 * numbers.
	 *
	 * @param list the list of employees
	 */
	public static void employeeSortedByID(Employee[] list) {
		Arrays.sort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i] + "\n");
		}
	}

	/**
	 * This method is used to display employees' information sorted by their
	 * last names.
	 *
	 * @param list the list of employees
	 */
	public static void employeeSortedByLastName(Employee[] list) {
		Arrays.sort(list, Employee.lastNameComparator);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i] + "\n");
		}
	}

	/**
	 * This method is used to verify the cloning process of a random employee's
	 * information.
	 *
	 * @param list the list of employees
	 */
	public static void cloneVerification(Employee[] list) {
		Employee temp = null;
		int i = (int) (Math.random() * 9);
		try {
			temp = (Employee) list[i].clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Error: Can't clone");
		}
		temp.setID("ModifiedID");
		temp.setLastName("ModifiedLastName");
		if (list[i] instanceof Faculty) {
			((Faculty) temp).setEducation(new Education());
		}
		System.out.println("-Original-");
		System.out.println(list[i]);
		System.out.println("-Modefied-");
		System.out.println(temp);
	}
}
