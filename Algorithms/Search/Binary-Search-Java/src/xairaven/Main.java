package xairaven;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int key = 688426; //number from largeWSorted.txt
        Scanner in = new Scanner("../resources/largeWSorted.txt");
        while(in.hasNextInt()) {
            System.out.println(in.nextInt());
        }
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
