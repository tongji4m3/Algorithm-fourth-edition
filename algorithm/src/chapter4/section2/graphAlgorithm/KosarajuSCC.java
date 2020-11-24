package chapter4.section2.graphAlgorithm;

import chapter1.section3.ResizingArrayStack;
import chapter4.section2.Digraph;

public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph digraph) {
        marked = new boolean[digraph.V()];
        id = new int[digraph.V()];
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph.reverse());
        for (int s : depthFirstOrder.getReversePost()) {
            if (!marked[s]) {
                dfs(digraph, s);
                ++count;
            }
        }


    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : digraph.adj(v)) {
            if(!marked[w]){
                dfs(digraph,w);
            }
        }
    }

    public boolean stronglyConnected(int v,int w) {
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }
}
