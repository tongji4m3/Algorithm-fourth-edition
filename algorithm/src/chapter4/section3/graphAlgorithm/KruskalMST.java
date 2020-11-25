package chapter4.section3.graphAlgorithm;

import chapter1.section3.Queue;
import chapter1.section5.WeightedQuickUnionUF;
import chapter4.section3.Edge;
import chapter4.section3.EdgeWeightedGraph;

//复制了<<算法4>>中的MinPQ类
public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph graph){
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge edge : graph.edges()) {
            pq.insert(edge);
        }
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(graph.V());

        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }
}
