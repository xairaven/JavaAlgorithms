package ua.xairaven.main.Graphs;
import edu.princeton.cs.algs4.In;
import ua.xairaven.main.DataStructures.Stacks.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfp(G, s);
    }

    private void dfp(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adjacency(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfp(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    /**
     * Depth First Paths search test
     * First arg - file tinyCG.txt with graphs (Tiny Graph Connected)
     * 6 vertices, 8 edges
     * Second - your choice (vertex)
     * All vertices is connected
     */
    public static void main(String[] args) {
        Graph G = new Graph(new In((args[0])));     // Java/res/txt_files/tinyCG.txt
        int s = Integer.parseInt(args[1]);          // vertex
        DepthFirstPaths dfp = new DepthFirstPaths(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (dfp.hasPathTo(v)) {
                System.out.printf("%d to %d:  ", s, v);
                for (int x : dfp.pathTo(v)) {
                    if (x == s) System.out.print(x);
                    else System.out.print("-" + x);
                }
                System.out.println();
            } else {
                System.out.printf("%d to %d:  not connected\n", s, v);
            }

        }
    }
}
