package chapter4.section2.graphAlgorithm;

import chapter4.section2.Digraph;

public class TransitiveClosure {
    private DirectedDFS[] all;

    public TransitiveClosure(Digraph digraph) {
        all = new DirectedDFS[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            all[v] = new DirectedDFS(digraph, v);
        }
    }

    public boolean reachable(int v,int w){
        return all[v].marked(w);
    }
}
