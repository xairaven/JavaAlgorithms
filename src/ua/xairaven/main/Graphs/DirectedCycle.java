package ua.xairaven.main.Graphs;
import edu.princeton.cs.algs4.In;
import ua.xairaven.main.DataStructures.Stacks.Stack;

public class DirectedCycle {
    private Stack<Integer> cycle;
    private boolean[] onStack;
    private boolean[] marked;
    private int[] edgeTo;

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adjacency(v)) {
            if (this.hasCycle()) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }


    // tests
    public static void main(String[] args) {
        In in = new In(args[0]);                    // Java/res/txt_files/tinyDG.txt
        Digraph G = new Digraph(in);
        DirectedCycle finder = new DirectedCycle(G);
        if (finder.hasCycle()) {
            System.out.print("Directed cycle: ");
            for (int v : finder.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println();
        } else {
            System.out.println("No directed cycle");
        }
        System.out.println();
    }
}
