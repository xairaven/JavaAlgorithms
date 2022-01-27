package xairaven;

public class MultiplicationAndExp {
    public static void main(int a, int b) {
        System.out.printf("%d * %d = %d\n", a, b, multiplication(a, b));
        System.out.printf("%d ^ %d = %d\n\n", a, b, exponentiation(a, b));
    }

    public static int multiplication(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return multiplication(a + a, b / 2);
        return multiplication(a + a, b / 2) + a;
    }

    public static int exponentiation(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return exponentiation(a * a, b / 2);
        return exponentiation(a * a, b / 2) * a;
    }
}
