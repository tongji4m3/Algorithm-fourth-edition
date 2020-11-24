package chapter4.section1.graphAlgorithm;

import chapter1.section3.Queue;
import chapter1.section3.ResizingArrayStack;
import chapter4.section1.Graph;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph graph,int s) {
        this.s = s;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while(!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w : graph.adj(v)) {
                if(!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
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
}
