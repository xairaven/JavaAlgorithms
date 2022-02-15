package UnionFind;

public class WeightedQuickUnion {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < id.length; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < sz.length; i++) sz[i] = i;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return this.count;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count --;
    }

    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
}
