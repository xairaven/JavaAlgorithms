package ua.xairaven.main.Sorting;

@SuppressWarnings("unchecked")
public class CocktailShakerSort {
    public static void sort(Comparable[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int swapLo, swapHi;
        while (lo < hi) {
            swapHi = 0;
            for (int i = lo; i < hi; i++) {
                if (less(arr[i + 1], arr[i])) {
                    exch(arr, i, i+1);
                    swapHi = i;
                }
            }
            hi = swapHi;
            swapLo = arr.length - 1;
            for (int j = hi; j > lo; j--) {
                if (less(arr[j], arr[j-1])) {
                    exch(arr, j-1, j);
                    swapLo = j;
                }
            }
            lo = swapLo;
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
