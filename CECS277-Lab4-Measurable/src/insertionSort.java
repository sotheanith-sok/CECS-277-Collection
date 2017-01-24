
/**
 * <h1>insertionSort</h1> insertionSort class contains static function used to
 * sort an array.
 *
 * @author Sotheanith Sok
 * @version 1.0
 * @since 2016-10-16
 */
public class insertionSort {

	/**
	 * This function is used to sort an array.
	 *
	 * @param array the array that needed to be sort
	 * @param size the size of array
	 */
	public static <T extends Comparable<T>> void sort(T[] array, int size) {
		T temp;
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (((Comparable<T>) array[j]).compareTo((T) array[j - 1]) < 0) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}
}
