package chapter4.section3.graphAlgorithm;

import chapter4.section3.Edge;
import chapter4.section3.EdgeWeightedGraph;

/*
为了不需要依赖,复制了<<算法4>>的MinPQ类放入自己的包中
且将使用IndexMinPQ改造为使用MinPQ实现
 */
public class PrimMST {
    private Edge[] edgeTo;//每个顶点距离树最近的边(0顶点没有此边)
    private double[] distTo;//每个顶点距离树最近的边的权重(0顶点此项为0)
    private boolean[] marked;//标记是否在树中.可以根据distTo是否可达判断
    private MinPQ<Edge> pq;

    public PrimMST(EdgeWeightedGraph graph) {
        edgeTo = new Edge[graph.V()];
        distTo = new double[graph.V()];
        marked = new boolean[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;//开始都不在树中
        }
        pq = new MinPQ<>(graph.V());
        distTo[0] = 0.0;//让0节点在树中
        Edge edge = new Edge(0, 0, 0.0);
        pq.insert(edge);//为了初始能加入几个顶点构成初始的树
        //如果横切边为空,则已经构造完成了
        while (!pq.isEmpty()) {
            //每次都将最近的顶点(横切边最小的)加入树中
            //每次选取的是有横切边的顶点里面,横切边最小的那个
            visit(graph, pq.delMin().either());
        }
    }

    private void visit(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge edge : graph.adj(v)) {
            int w = edge.other(v);
            /*已经在树中的节点忽略掉,不会有问题:
            因为一个时刻加入的肯定是最小的那个横切边,即贪心算法
             */
            if (marked[w]) continue;
            //对本来到树不可达的顶点和到树有更近距离的顶点进行了更新
            //对于不可达顶点来说,相当于加入了一条到树的横切边
            //对于可达顶点来说,相当于更新了横切边,使得该顶点到树的当前时候的横切边最小
            if (edge.weight() < distTo[w]) {
                edgeTo[w] = edge;
                distTo[w] = edge.weight();
                //有到树路径的顶点更新路径
                //没有到树路径的顶点则会插入队列中
                // TODO: 2020/11/24  
                if (pq.contains(edge)) pq.change(edge);
                else pq.insert(edge);
            }
        }
    }
}
