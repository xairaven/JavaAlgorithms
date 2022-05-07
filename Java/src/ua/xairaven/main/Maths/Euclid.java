package ua.xairaven.main.Maths;

public class Euclid {
    public static int Euclid(int p, int q) {
        System.out.printf("p = %d    q = %d\n", p, q);
        if (q == 0) return p;
        int r = p % q;
        return Euclid(q, r);
    }

    // tests
    public static void main(String[] args) {
        int a = 105, b = 24;
        System.out.printf("\nEuclid(%d, %d)\n", a, b);
        System.out.printf("Result = %d\n", Euclid(a,b));
        System.out.print("\n");
    }
}
