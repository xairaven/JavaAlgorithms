package xairaven;

public class Fibonacci {
    public static void main(int N) {
        System.out.printf("Fibonacci recursion result: %d\n", fibonacciRecurse(N));
        System.out.printf("Fibonacci cycle result: %d\n", fibonacciCycle(N));
        System.out.print("\n");
    }

    public static long fibonacciCycle(int N) {
        long first = 0 , second = 1;
        long num = 0; long temp;
        for (int i = 2; i <= N; i++) {
            num = first + second;
            temp = second;
            first = temp;
            second = num;
        }
        return num;
    }

    public static long fibonacciRecurse(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return fibonacciRecurse(N-1) + fibonacciRecurse(N-2);
    }
}
