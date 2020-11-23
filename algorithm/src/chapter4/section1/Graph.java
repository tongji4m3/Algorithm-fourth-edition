package chapter4.section1;

import chapter1.section3.Bag;

import java.util.Arrays;

public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int v) {
        V = v;
        E = 0;
        adj = (Bag<Integer>[])new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        ++E;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(V);
        stringBuilder.append("个顶点,");
        stringBuilder.append(E);
        stringBuilder.append("条边\n");
        for (int v = 0; v < V; v++) {
            stringBuilder.append(v);
            stringBuilder.append(":");
            for (int w : adj[v]) {
                stringBuilder.append(w);
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
