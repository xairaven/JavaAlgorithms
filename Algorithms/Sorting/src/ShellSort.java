@SuppressWarnings("unchecked")
public class ShellSort {
    public static void sort(Comparable[] arr) {
        int h = 1;
        while (h < arr.length/3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
                    exch(arr, j, j - h);
                }
                h /= 3;
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }
}