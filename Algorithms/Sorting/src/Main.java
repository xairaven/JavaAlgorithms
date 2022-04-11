import java.io.FileWriter;
import java.io.IOException;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

/**
 * Unit-test
 * File: 32Kints
 */
public class Main {
    public static void main(String[] args) {
        String rawFile = "Algorithms/resources/txt_files/32Kints.txt";
        String resFolder = "Algorithms/Sorting/result/";
        Integer[] arr = readAllInts(rawFile);

        System.out.println("Menu:");
        System.out.println(" 1. Bubble");
        System.out.println(" 2. Selection");
        System.out.println(" 3. Insertion");
        System.out.println(" 4. Shell");
        System.out.println(" 5. Mergesort");
        System.out.println(" 6. CocktailShakerSort");
        System.out.println(" 7. Quicksort");
        In in = new In();
        int choice = in.readInt();
        long start, time;
        String sort;
        switch (choice) {
            case 1 -> sort = "Bubble";
            case 2 -> sort = "Selection";
            case 3 -> sort = "Insertion";
            case 4 -> sort = "Shell";
            case 5 -> sort = "Mergesort";
            case 6 -> sort = "CocktailShakerSort";
            case 7 -> sort = "Quicksort";
            default -> {
                System.out.println("Wrong choice.");
                return;
            }
        }

        description(sort);
        Integer[] copyArr = copy(arr);
        start = System.currentTimeMillis();
        switch (choice) {
            case 1 -> BubbleSort.sort(copyArr);
            case 2 -> SelectionSort.sort(copyArr);
            case 3 -> InsertionSort.sort(copyArr);
            case 4 -> ShellSort.sort(copyArr);
            case 5 -> MergeSort.sort(copyArr);
            case 6 -> CocktailShakerSort.sort(copyArr);
            case 7 -> Quicksort.sort(copyArr);
            default -> {
                System.out.println("Wrong choice.");
                return;
            }
        }
        time = System.currentTimeMillis() - start;

        System.out.println("Execution time: " + time + "ms. ");
        writeTime(resFolder + "AllTests.txt", sort + ": " + time + " ms.");

        writeArr(resFolder + sort.toLowerCase() + ".txt", copyArr);
    }

    private static void show(Comparable[] a) {
        for (Comparable item : a) {
            System.out.println(item);
        }
    }

    private static void writeArr(String path, Comparable[] arr) {
        Out out = new Out(path);
        for(Comparable item : arr) {
            out.println(item);
        }
    }

    private static void writeTime(String path, String str) {
        /*Out out = new Out(path);
        out.println(str);*/
        try (FileWriter writer = new FileWriter(path, true))
        {
            writer.write(str + "\n");
            writer.flush();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static Integer[] readAllInts(String rawFile) {
        In in = new In(rawFile);
        String[] fields = in.readAllStrings();
        Integer[] values = new Integer[fields.length];
        for (int i = 0; i < fields.length; i++)
            values[i] = Integer.parseInt(fields[i]);
        return values;
    }

    private static void description(String sort) {
        System.out.println("-- " + sort + " sort --");
        System.out.println("Input: Algorithms/resources/txt_files/32Kints.txt");
        System.out.println("Output: Algorithms/Sorting/result/" + sort.toLowerCase() + ".txt");
    }

    private static Integer[] copy(Integer[] arr) {
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) temp[i] = arr[i];
        return temp;
    }
}
