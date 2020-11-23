package chapter4.section1.graphAlgorithm;

import chapter4.section1.Graph;

public class CommonAlgorithm {
    public static int degree(Graph graph,int v){
        int degree = 0;
        for (int w : graph.adj(v)) {
            ++degree;
        }
        return degree;
    }
    public static int maxDegree(Graph graph){
        int max = 0;
        for (int v = 0; v < graph.V(); v++) {
            if(degree(graph,v)>max){
                max = degree(graph, v);
            }
        }
        return max;
    }

    public static double avgDegree(Graph graph){
        return 2.0 * graph.E() / graph.V();
    }

    public static int numberOfSelfLoops(Graph graph){
        int count = 0;
        for (int v = 0; v < graph.V(); v++) {
            for (int w : graph.adj(v)) {
                if(v==w) ++count;
            }
        }
        return count / 2;
    }
}
