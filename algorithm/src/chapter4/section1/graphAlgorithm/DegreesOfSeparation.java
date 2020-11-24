package chapter4.section1.graphAlgorithm;

import chapter4.section1.Graph;

public class DegreesOfSeparation {
    public static void main(String[] args) {
        SymbolGraph symbolGraph = new SymbolGraph();
        Graph graph = symbolGraph.G();
        String source = "hello";
        int s = symbolGraph.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, s);
        String sink = "world";
        if (symbolGraph.contains(sink)) {
            int t = symbolGraph.index(sink);
            if (bfs.hasPathTo(t)) {
                for (int v : bfs.pathTo(t)) {
                    System.out.println(symbolGraph.name(v));
                }
            }
            else {
                System.out.println("Not  connected!");
            }
        }
    }
}
