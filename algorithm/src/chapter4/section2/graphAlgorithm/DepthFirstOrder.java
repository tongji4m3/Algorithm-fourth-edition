package chapter4.section2.graphAlgorithm;

import chapter1.section3.Queue;
import chapter1.section3.Stack;
import chapter4.section2.Digraph;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph digraph){
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            if(!marked[v]) dfs(digraph, v);
        }
    }

    private void dfs(Digraph digraph, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for(int w:digraph.adj(v)){
            if(!marked[w]) dfs(digraph, w);
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Queue<Integer> getPre() {
        return pre;
    }

    public Queue<Integer> getPost() {
        return post;
    }

    public Stack<Integer> getReversePost() {
        return reversePost;
    }
}
