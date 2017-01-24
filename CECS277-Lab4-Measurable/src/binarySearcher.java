/**
 * <h1>binarySearcher</h1> binarySearcher is an object used to store and find
 * the length of string.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-10-16
 */
public class binarySearcher<T extends Comparable<T>> {

	/**
	 * The array is the array that stored a list of value that needed to be
	 * search.
	 */
	private T[] array;

	/**
	 * Instantiates a new binary searcher with a given value.
	 *
	 * @param a the array that needed to be search
	 */
	public binarySearcher(T[] a) {
		array = a;
	}

	/**
	 * Search an array for a given value.
	 *
	 * @param value the value that needed to be search
	 * @return the position of the first occurrence of value or return -1 if
	 *         value doesn't exist in the array
	 */
	public int search(T value) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int diff = array[mid].compareTo(value);
			if (diff == 0) {
				return mid;
			} else if (diff < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
