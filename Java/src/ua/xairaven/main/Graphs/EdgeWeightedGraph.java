package ua.xairaven.main.Graphs;
import edu.princeton.cs.algs4.In;
import ua.xairaven.main.DataStructures.Bags.Bag;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adjacency;

    public EdgeWeightedGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("number of vertices have to be > 0");
        this.V = V;
        this.E = 0;
        adjacency = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adjacency[v] = new Bag<>();
        }
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("number of edges have to be > 0");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either(); validateVertex(v);
        int w = e.other(v); validateVertex(w);
        adjacency[v].add(e);
        adjacency[w].add(e);
        E++;
    }

    public int degree(int v) {
        validateVertex(v);
        return adjacency[v].size();
    }

    public Iterable<Edge> adj(int v) {
        validateVertex(v);
        return adjacency[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> edges = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adjacency[v]) {
                if (e.other(v) > v) edges.add(e);
            }
        }
        return edges;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adjacency[v]) {
                s.append(e + "  ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    // tests
    public static void main(String[] args) {
        In in = new In(args[0]);    // Java/res/txt_files/tinyEWG.txt
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        System.out.println(G);
    }
}
