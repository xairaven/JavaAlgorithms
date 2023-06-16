package ua.xairaven.main.Graphs;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import ua.xairaven.main.DataStructures.SymbolTables.RedBlackBST;

public class SymbolGraph {
    private RedBlackBST<String, Integer> st;
    private String[] keys;
    private Graph graph;

    public SymbolGraph(String filename, String delimiter) {
        st = new RedBlackBST<>();
        In in = new In(filename);
        while (!in.isEmpty()) {
            String[] a = in.readLine().split(delimiter);
            for (String s : a) {
                if (!st.contains(s))
                    st.put(s, st.size());
            }
        }
        System.out.println("Done reading " + filename);

        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }
        graph = new Graph(st.size());
        in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = st.get(a[i]);
                graph.addEdge(v, w);
            }
        }
    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int indexOf(String s) {
        return st.get(s);
    }

    public String nameOf(int v) {
        return keys[v];
    }

    public Graph graph() {
        return graph;
    }

    public static void main(String[] args) {
        String filename  = args[0];
        String delimiter = " ";
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph graph = sg.graph();
        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            if (sg.contains(source)) {
                int s = sg.indexOf(source);
                for (int v : graph.adjacency(s)) {
                    System.out.println("   " + sg.nameOf(v));
                }
            }
            else {
                System.out.println("input not contain '" + source + "'");
            }
        }
    }
}