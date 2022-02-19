import java.io.FileWriter;
import java.io.IOException;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

/**
 * Unit-test
 * File: 32Kints
 */
public class Main {
    public static void main(String[] args) {
        String rawFile = "Algorithms/resources/txt_files/32Kints.txt";
        String resFolder = "Algorithms/Sorting/result/";
        Integer[] arr = readAllInts(rawFile);

        System.out.println("Menu\n 1. Bubble\n 2. Selection\n 3. Insertion \n 4. Shell");
        In in = new In();
        int choice = in.readInt();
        long start, time;
        switch (choice) {
            case 1 -> {
                description("Bubble");

                Integer[] bubbleArr = copy(arr);

                start = System.currentTimeMillis();
                BubbleSort.sort(bubbleArr);
                time = System.currentTimeMillis() - start;

                System.out.println("Execution time: " + time + "ms. ");
                writeTime(resFolder + "AllTests.txt", "Bubble: " + time + " ms.");

                writeArr(resFolder + "bubble.txt", bubbleArr);
            }
            case 2 -> {
                description("Selection");

                Integer[] selectionArr = copy(arr);

                start = System.currentTimeMillis();
                SelectionSort.sort(selectionArr);
                time = System.currentTimeMillis() - start;

                System.out.println("Execution time: " + time + "ms. ");
                writeTime(resFolder + "AllTests.txt", "Selection: " + time + " ms.");

                writeArr(resFolder + "selection.txt", selectionArr);
            }
            case 3 -> {
                description("Insertion");

                Integer[] insertionArr = copy(arr);

                start = System.currentTimeMillis();
                SelectionSort.sort(insertionArr);
                time = System.currentTimeMillis() - start;

                System.out.println("Execution time: " + time + "ms. ");
                writeTime(resFolder + "AllTests.txt", "Insertion: " + time + " ms.");

                writeArr(resFolder + "insertion.txt", insertionArr);
            }
            case 4 -> {
                description("Shell");

                Integer[] shellArr = copy(arr);

                start = System.currentTimeMillis();
                SelectionSort.sort(shellArr);
                time = System.currentTimeMillis() - start;

                System.out.println("Execution time: " + time + "ms. ");
                writeTime(resFolder + "AllTests.txt", "Shell: " + time + " ms.");

                writeArr(resFolder + "shell.txt", shellArr);
            }
        }
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
        System.out.println("Output: Algorithms/Sorting/result/insertion.txt");
    }

    private static Integer[] copy(Integer[] arr) {
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) temp[i] = arr[i];
        return temp;
    }
}
