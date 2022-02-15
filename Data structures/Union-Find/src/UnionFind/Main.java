package UnionFind;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nodes: ");
        int N = scan.nextInt();
        System.out.println("Amount of connects: ");
        int am = scan.nextInt();

        UnionFind UF = new UnionFind(N);
        QuickUnion QU = new QuickUnion(N);
        WeightedQuickUnion WQU = new WeightedQuickUnion(N);

        long UFsum = 0;
        long QUsum = 0;
        long WQUsum = 0;

        for (int i = 0; i < am; i++) {
            int p = scan.nextInt();
            int q = scan.nextInt();

            long start = System.currentTimeMillis();
            if (UF.connected(p, q)) continue;
            UF.union(p, q);
            UFsum += System.currentTimeMillis()- start;

            start = System.currentTimeMillis();
            if (QU.connected(p, q)) continue;
            QU.union(p, q);
            QUsum += System.currentTimeMillis()- start;

            start = System.currentTimeMillis();
            if (WQU.connected(p, q)) continue;
            WQU.union(p, q);
            WQUsum += System.currentTimeMillis()- start;

            System.out.println(p + " " + q);
        }
        System.out.println("UF = " + UFsum);
        System.out.println("QU = " + QUsum);
        System.out.println("WQU = " + WQUsum);
    }
}
