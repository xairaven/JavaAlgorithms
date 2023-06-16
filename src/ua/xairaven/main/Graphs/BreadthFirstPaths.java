package ua.xairaven.main.Graphs;
import edu.princeton.cs.algs4.In;
import ua.xairaven.main.DataStructures.Queues.Queue;
import ua.xairaven.main.DataStructures.Stacks.Stack;

public class BreadthFirstPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;
    private int[] distTo;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> q = new Queue<>();
        for (int v = 0; v < G.V(); v++) distTo[v] = INFINITY;
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);
        while(!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adjacency(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public int distTo(int v) {
        return distTo[v];
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
     * Breadth First Paths search test
     * First arg - file tinyCG.txt with graphs (Tiny Graph Connected)
     * 6 vertices, 8 edges
     * Second - your choice (vertex)
     * All vertices is connected
     */
    public static void main(String[] args) {
        In in = new In(args[0]);                // Java/res/txt_files/tinyCG.txt
        Graph G = new Graph(in);
        System.out.println(G);                  // printing graph

        int s = Integer.parseInt(args[1]);      // vertex
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (bfs.hasPathTo(v)) {
                System.out.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)) {
                    if (x == s) System.out.print(x);
                    else System.out.print("-" + x);
                }
                System.out.println();
            } else {
                System.out.printf("%d to %d (-):  not connected\n", s, v);
            }
        }
    }
}
