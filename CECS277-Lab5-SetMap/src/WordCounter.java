import java.io.*;
import java.util.*;

/**
 * <h1>WordCounternk</h1> This program is used to count the quantity of words in
 * a data.txt
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-10-31
 */
public class WordCounter {

	public static void main(String[] args) {
		Map<String, Integer> wordMap = new HashMap<String, Integer>(20);
		createMap(wordMap);// Read and count the word
		displayMap(wordMap);// display the map contain
	}

	/**
	 * This function is used to read data from data.txt
	 *
	 * @param x the Map that used to store the word
	 */
	public static void createMap(Map<String, Integer> x) {
		// Read data form the file line by line
		try {
			Scanner input = new Scanner(new File("data.txt"));
			while (input.hasNextLine()) {
				String inputLine = input.nextLine();
				String[] tokens = inputLine.split(" ");
				for (String s : tokens) {
					if (s.trim().length() > 0) {
						if (x.containsKey(s)) {
							x.put(s, x.get(s) + 1);
						} else {
							x.put(s, 1);
						}
					}
				}
			}
		} catch (FileNotFoundException fnf) {
			System.out.println("File was not found");
		}
	}

	/**
	 * This function is used to display words and their counters from a Map
	 *
	 * @param x the Map that store words
	 */
	public static void displayMap(Map<String, Integer> x) {
		// Making entry to access the value and key
		Set<Map.Entry<String, Integer>> s = x.entrySet();
		System.out.printf("-List of Words-\n%-8s %-8s \n", "-Words-", "-Amount-");
		// Print out the counter
		int largest = 0;
		for (Map.Entry<String, Integer> entry : s) {
			if (largest < entry.getValue())
				largest = entry.getValue();
			System.out.printf("%-8s %-8d \n", entry.getKey(), entry.getValue());
		}
		System.out.printf("\n-Most Frequent Occurence-\n%-8s %-8s \n", "-Words-", "-Amount-");
		for (Map.Entry<String, Integer> entry : s) {
			if (entry.getValue() == largest) {
				System.out.printf("%-8s %-8d \n", entry.getKey(), entry.getValue());
			}
		}
	}
}
