package UnionFind;

/**
 * Implementation of Union Find<br>
 * Date: 19.02.2022
 * @author Alex "xairaven" Kovalyov
 */
public class UnionFind {
    private int[] id;
    private int count;

    public UnionFind(int N) {
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
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count --;
    }

    public int find(int p) {
        return id[p];
    }
}

