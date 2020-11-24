package chapter4.section2.graphAlgorithm;

import chapter4.section1.Graph;
import chapter4.section2.Digraph;

public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph digraph) {
        DirectedCycle cycle = new DirectedCycle(digraph);
        if(!cycle.hasCycle()){
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
            order = depthFirstOrder.getReversePost();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean isDAG(){
        return order != null;
    }
}
