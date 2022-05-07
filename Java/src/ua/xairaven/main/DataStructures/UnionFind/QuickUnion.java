package ua.xairaven.main.DataStructures.UnionFind;

/**
 * Implementation of Quick Union<br>
 * Date: 19.02.2022
 * @author Alex "xairaven" Kovalyov
 */
public class QuickUnion {
    private int[] id;
    private int count;

    public QuickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return this.count;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count --;
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }
}
