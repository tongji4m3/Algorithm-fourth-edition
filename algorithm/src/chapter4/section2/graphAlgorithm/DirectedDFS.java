package chapter4.section2.graphAlgorithm;

import chapter1.section3.Bag;
import chapter4.section1.Graph;
import chapter4.section2.Digraph;

public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph graph, Iterable<Integer> sources) {
        marked = new boolean[graph.V()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(graph, s);
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public static void main(String[] args) {
        Digraph digraph = new Digraph(10);
        Bag<Integer> sources = new Bag<>();
        DirectedDFS directedDFS = new DirectedDFS(digraph, sources);
        for (int v = 0; v < digraph.V(); v++) {
            if(directedDFS.marked(v)){
                System.out.printf(v+" ");
            }
        }
    }
}
