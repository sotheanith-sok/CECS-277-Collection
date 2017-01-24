import java.util.*;

/**
 * <h1>EmployeeDatabase</h1> EmployeeDatabase is used to store Employees'
 * information in a HashMap.
 * 
 * @author Sotheanith Sok
 * @since 11-7-2016
 * @version 1.0
 */
public class EmployeeDatabase {

	public static void main(String[] args) {
		Map<Employee, Performance> PerformanceMap = new HashMap<Employee, Performance>();
		Map<String, Employee> employeeMap = new HashMap<String, Employee>();
		boolean done = false;
		while (!done) {
			int choice = printMenuAndGetChoice(0);
			switch (choice) {
			case 1:
				System.out.println("-Adding Employee-");
				addEmployee(PerformanceMap, employeeMap);
				break;
			case 2:
				System.out.println("-Removing Employee-");
				removeEmployee(PerformanceMap, employeeMap);
				break;
			case 3:
				System.out.println("-Modifying Employee Performance-");
				modifyPerformance(PerformanceMap, employeeMap);
				break;
			case 4:
				System.out.println("-Printing Employee Performance-");
				printEmployeePerformance(PerformanceMap);
				break;
			case 5:
				System.out.println("-Exiting-");
				done = true;
				break;
			default:
				System.err.print("Invalid Input");
				break;
			}
		}
	}

	/**
	 * This function is used to print menu and get user choice.
	 *
	 * @param i 0 for main menu or 1 for performance menu.
	 * @return the user choice.
	 */
	public static int printMenuAndGetChoice(int i) {
		Scanner in = new Scanner(System.in);
		int choice = 0;
		boolean done = false;
		while (!done) {
			try {
				if (i == 0) {
					System.out.println("--Main Menu--");
					System.out.println("1. Add Employee");
					System.out.println("2. Remove Employee");
					System.out.println("3. Modify Employee Performance");
					System.out.println("4. Print Employee Performance");
					System.out.println("5. Exit");
				} else {
					System.out.println("--Performance Option--");
					System.out.println("1. Excellent");
					System.out.println("2. Good");
					System.out.println("3. Satisfactory");
					System.out.println("4. Improvment");
					System.out.println("5. Exit");
				}
				choice = in.nextInt();
				if (choice < 1 || choice > 5) {
					throw new NumberFormatException();
				}
				done = true;
			} catch (NumberFormatException nfe) {
				System.err.println("Invalid Input. Please try again.");

			} catch (InputMismatchException ime) {
				System.err.println("Invalid Input. Please try again.");
				in.nextLine();
			}
		}
		return choice;
	}

	/**
	 * Adds an employee based on user input. Prints an error if a employee is
	 * added that already exists in the map.
	 *
	 * @param PerformanceMap the map to associate employee object with a
	 *            performance
	 * @param employeeMap the map to associate employee id with an employee.
	 */
	public static void addEmployee(Map<Employee, Performance> PerformanceMap, Map<String, Employee> employeeMap) {
		Scanner in = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			try {
				System.out.print("Enter first name: ");
				String firstName = in.next();
				System.out.print("Enter last name: ");
				String lastName = in.next();
				System.out.print("Enter id: ");
				int id = in.nextInt();
				if (id < 0)
					throw new InputMismatchException();
				int choice = printMenuAndGetChoice(1);
				Performance performance = null;

				switch (choice) {
				case 1:
					performance = Performance.Excellent;
					break;
				case 2:
					performance = Performance.Good;
					break;
				case 3:
					performance = Performance.Improvement;
					break;
				case 4:
					performance = Performance.Satisfactory;
					break;
				case 5:
					System.out.println("-Incomplete Employee Information. Return To Main Menu-");
					break;
				default:
					System.out.println("Invalid input");
					break;
				}
				if (choice != 5) {
					Employee temp = new Employee(firstName, lastName, id);
					PerformanceMap.put(temp, performance);
					int preSize = employeeMap.size();
					employeeMap.put(Integer.toString(id), temp);
					int posSize = employeeMap.size();
					if (preSize == posSize) {
						System.out.println("-Employee already existed in the list-");
					} else {
						System.out.println("-Added Employee to the list-");
					}
				}
				done = true;

			} catch (InputMismatchException nfe) {
				System.err.println("-Invalid input.Please try again!!!-");
				in.nextLine();
			}
		}
	}

	/**
	 * Removes a employee from the map based on user input
	 * 
	 * @param PerformanceMap the map to associate employee object with a
	 *            performance.
	 * @param employeeMap the map to associate employee id with an employee.
	 */
	public static void removeEmployee(Map<Employee, Performance> PerformanceMap, Map<String, Employee> employeeMap) {
		if (employeeMap.size() == 0) {
			System.out.println("-Nothing to be remove.  Empty map detected-");
		} else {
			String key = printEmployee(employeeMap);
			Employee temp = employeeMap.remove(key);
			PerformanceMap.remove(temp);
			System.out.println("Removed: " + temp);
		}
	}

	/**
	 * Prints the employees and performances
	 * 
	 * @param PerformanceMa the map to print
	 */
	public static void printEmployeePerformance(Map<Employee, Performance> PerformanceMap) {
		TreeMap<Employee, Performance> temp = new TreeMap<Employee, Performance>();
		temp.putAll(PerformanceMap);
		if (PerformanceMap.size() == 0) {
			System.out.println("-Nothing to be print.  Empty map detected-");
		} else {
			System.out.printf("%-10s %-10s\n", "Name", "Performance");
			for (Map.Entry<Employee, Performance> entry : temp.entrySet())
				System.out.printf("%-10s %-10s\n", entry.getKey(), entry.getValue());
		}
	}

	/**
	 * Modifies an entry based on user input. Prints an error if an invalid
	 * employee is modified.
	 * 
	 * @param PerformanceMap the map to associate employee object with a
	 *            performance.
	 * @param employeeMap the map to associate employee id with an employee
	 */
	public static void modifyPerformance(Map<Employee, Performance> PerformanceMap, Map<String, Employee> employeeMap) {
		if (employeeMap.size() == 0) {
			System.out.println("-Nothing to be modify. Empty map detected-");
		} else {
			String key = printEmployee(employeeMap);
			Employee temp = employeeMap.get(key);
			System.out.println("-Current Performance: " + PerformanceMap.get(temp) + "-");
			int choice = printMenuAndGetChoice(1);
			switch (choice) {
			case 1:
				PerformanceMap.put(temp, Performance.Excellent);
				break;
			case 2:
				PerformanceMap.put(temp, Performance.Good);
				break;
			case 3:
				PerformanceMap.put(temp, Performance.Satisfactory);
				break;
			case 4:
				PerformanceMap.put(temp, Performance.Improvement);
				break;
			case 5:
				System.out.println("-Going back to menu-");
				break;
			default:
				System.err.println("-Invalid input-");
				break;
			}
		}

	}

	/**
	 * Prints the employees' ID and Name and get the user choice.
	 *
	 * @param employeeMap the map to print and choose from
	 * @return user's choice
	 */
	public static String printEmployee(Map<String, Employee> employeeMap) {
		Scanner in = new Scanner(System.in);
		String choice = "";
		boolean done = false;
		System.out.printf("%-10s %-10s\n", "ID", "Name");
		for (Map.Entry<String, Employee> entry : employeeMap.entrySet())
			System.out.printf("%-10s %-10s\n", entry.getKey(), entry.getValue());
		while (!done) {
			try {
				System.out.print("Enter ID: ");
				choice = in.next();
				if (!employeeMap.containsKey(choice)) {
					throw new NumberFormatException();
				}
				done = true;
			} catch (NumberFormatException nfe) {
				System.err.println("-Invalid Input-");
			}
		}
		return choice;

	}
}
