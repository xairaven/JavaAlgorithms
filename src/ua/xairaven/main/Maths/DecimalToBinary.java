package ua.xairaven.main.Maths;

public class DecimalToBinary {
    public static void decimalToBinary(int N) {
        String s = "";
        for (int n = N; n > 0; n /= 2) {
            s = (n % 2) + s;
        }
        System.out.println(s);
        System.out.print("\n");
    }

    // tests
    public static void main(String[] args) {
        decimalToBinary(52);
    }
}
