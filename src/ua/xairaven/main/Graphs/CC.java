package ua.xairaven.main.Graphs;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.In;

// Compute connected components using depth first search
public class CC {
    private boolean[] marked;
    private int[] id;
    private int[] size;
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : G.adjacency(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public int id(int v) {
        return id[v];
    }

    public int size(int v) {
        return size[id[v]];
    }

    public int count() {
        return count;
    }

    public boolean connected(int v, int w) {
        return id(v) == id(w);
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);
        int M = cc.count();
        System.out.println(M + " components");
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].enqueue(v);
        }
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
