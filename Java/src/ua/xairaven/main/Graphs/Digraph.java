package ua.xairaven.main.Graphs;
import ua.xairaven.main.DataStructures.Bags.Bag;
import edu.princeton.cs.algs4.In; // for tests
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Digraph {
    private final int V;
    private int E;
    private int[] inDegree;
    private Bag<Integer>[] adjacency;

    public Digraph(int V) {
        if (V < 0) throw new IllegalArgumentException("number of vertices in Diagraph have to be > 0");
        this.V = V;
        this.E = 0;
        inDegree = new int[V];
        adjacency = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adjacency[v] = new Bag<>();
        }
    }

    public Digraph(In in) {
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in Diagraph have to be > 0");
            inDegree = new int[V];
            adjacency = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adjacency[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Digraph have to be > 0");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                addEdge(v, w);
            }
        } catch (NoSuchElementException e) {
            throw new InputMismatchException("Invalid input format in Digraph constructor");
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    public void addEdge(int v, int w) {
        validateVertex(v); validateVertex(w);
        adjacency[v].add(w);
        inDegree[w]++;
        E++;
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adjacency(v)) {
                addEdge(w, v);
            }
        }
        return R;
    }

    public int outDegree(int v) {
        validateVertex(v);
        return adjacency[v].size();
    }

    public int inDegree(int v) {
        validateVertex(v);
        return inDegree[v];
    }

    public Iterable<Integer> adjacency(int v) {
        validateVertex(v);
        return adjacency[v];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adjacency[v]) {
                s.append(String.format("%d ", w));
            }
            s.append("\n");
        }
        return s.toString();
    }

    // tests
    public static void main(String[] args) {
        In in = new In(args[0]);        // Java/res/txt_files/tinyDG.txt
        Digraph G = new Digraph(in);
        System.out.println(G);
    }
}
