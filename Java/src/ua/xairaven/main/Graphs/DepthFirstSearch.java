package ua.xairaven.main.Graphs;
import edu.princeton.cs.algs4.In;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adjacency(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }

    /**
     * Depth First Search test
     * First arg - file tinyG.txt with graphs
     * 13 vertices, 13 edges
     * Second - your choice (vertex)
     * All vertices is not connected
     * 0-1-2-3-4-5-6 7-8 9-10-11-12
     */
    public static void main(String[] args) {
        In in = new In(args[0]);            // Java/res/txt_files/tinyG.txt
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]); // vertex
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v)) System.out.print(v + " ");
        }
        System.out.println();
        if (search.count() != G.V()) System.out.println("NOT connected");
        else System.out.println("connected");
    }
}
