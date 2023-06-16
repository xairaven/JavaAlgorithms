package ua.xairaven.main.Graphs;
import edu.princeton.cs.algs4.StdIn;

public class DegreesOfSeparation {
    private DegreesOfSeparation() {}

    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.graph();
        String source = args[2];
        if (!sg.contains(source)) {
            System.out.println(source + " not in database.");
            return;
        }
        int s = sg.indexOf(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if (sg.contains(sink)) {
                int t = sg.indexOf(sink);
                if (bfs.hasPathTo(t)) {
                    for (int v : bfs.pathTo(t)) {
                        System.out.println("   " + sg.nameOf(v));
                    }
                }
                else {
                    System.out.println("Not connected");
                }
            }
            else {
                System.out.println("   Not in database.");
            }
        }
    }
}
