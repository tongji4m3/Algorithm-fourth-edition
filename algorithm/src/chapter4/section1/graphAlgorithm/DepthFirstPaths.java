package chapter4.section1.graphAlgorithm;

import chapter4.section1.Graph;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph graph,int s) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(graph,w);
            }
        }
    }
    //todo
    

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        int s = 0;
        for (int v = 0; v < graph.V(); v++) {

        }
    }
}
