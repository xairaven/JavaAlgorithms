package xairaven;
import edu.princeton.cs.introcs.In;

public class Main {
    public static void main(String[] args) {
        int key = 688426; //random number from largeWSorted.txt
        In in = new In("../resources/largeWSorted.txt");
        int[] array = in.readAllInts();
        int index = binarySearch(key, array, 0, array.length - 1);
        System.out.printf("Index of number %d is %d", key, index);
    }

    public static int binarySearch(int key, int[] arr, int lo, int hi) {
        if (arr == null) throw new IllegalArgumentException();
        if (lo <= hi) {
            int middle = lo + (hi - lo) / 2;
            if (key < arr[middle]) return binarySearch(key, arr, lo, middle - 1);
            else if (key > arr[middle]) return binarySearch(key, arr, middle + 1, hi);
            else return middle;
        } else {
            return -1;
        }
    }
}
