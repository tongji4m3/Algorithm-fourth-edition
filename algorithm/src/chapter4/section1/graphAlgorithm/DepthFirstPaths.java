package chapter4.section1.graphAlgorithm;

import chapter1.section3.ResizingArrayStack;
import chapter1.section3.Stack;
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
    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        ResizingArrayStack<Integer> path = new ResizingArrayStack<>();
        for (int x = v; x != s; x=edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0,5);
        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(1,2);
        graph.addEdge(0,1);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(0,2);
        int s = 0;
        DepthFirstPaths paths = new DepthFirstPaths(graph, s);
        for (int v = 0; v < graph.V(); v++) {
            System.out.println(s + " to " + v + ":");
            if(paths.hasPathTo(v)){
                for (int x : paths.pathTo(v)) {
                    if(x==s) System.out.print("\t"+x);
                    else System.out.print("-"+x);
                }
                System.out.println();
            }
        }
    }
}
