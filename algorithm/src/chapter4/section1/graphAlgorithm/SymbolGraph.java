package chapter4.section1.graphAlgorithm;

import chapter4.section1.Graph;

import java.util.HashMap;
import java.util.Scanner;

public class SymbolGraph {
    private HashMap<String, Integer> st;
    private String[] keys;
    private Graph graph;

    public SymbolGraph(){
        st = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String[] a = scanner.nextLine().split(" ");
            for (int i = 0; i < a.length; i++) {
                if(!st.containsKey(a[i])){
                    st.put(a[i], st.size());
                }
            }
        }
        keys = new String[st.size()];
        for (String name : st.keySet()) {
            keys[st.get(name)] = name;
        }
        graph = new Graph(st.size());
        scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] a = scanner.nextLine().split(" ");
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                graph.addEdge(v,st.get(a[i]));
            }
        }
    }

    public boolean contains(String s){
        return st.containsKey(s);
    }

    public int index(String s){
        return st.get(s);
    }

    public String name(int v){
        return keys[v];
    }

    public Graph G(){
        return graph;
    }

    public static void main(String[] args) {
        SymbolGraph symbolGraph = new SymbolGraph();
        Graph graph = symbolGraph.G();
        String source = "hello";
        for (int w : graph.adj(symbolGraph.index(source))) {
            System.out.println(symbolGraph.name(w));

        }

    }
}
