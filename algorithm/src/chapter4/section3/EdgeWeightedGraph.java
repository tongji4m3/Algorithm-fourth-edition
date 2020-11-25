package chapter4.section3;

import chapter1.section3.Bag;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        ++E;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges(){
        Bag<Edge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for(Edge e:adj[v]){
                //两条边只会添加一条,如0-1,1-0,只会添加0-1
                if(e.other(v)>v) bag.add(e);
            }
        }
        return bag;
    }
}
