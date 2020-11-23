package chapter3.section2;

import chapter1.section3.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x.value;
        else if (cmp > 0) return get(x.right, key);
        else return get(x.left, key);
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min(){
        Node min = min(root);
        if(min==null) return null;
        return min.key;
    }

    private Node min(Node x){
        if(x.left==null) return x;
        return min(x.left);
    }

    public Key max(){
        Node max = max(root);
        if(max==null) return null;
        return max.key;
    }

    private Node max(Node x) {
        if(x.right==null) return x;
        return max(x.right);
    }

    public Key floor(Key key){
        Node x = floor(root, key);
        if(x==null) return null;
        return x.key;
    }

    private Node floor(Node x,Key key){
        if(x==null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp==0) return x;
        if(cmp<0) return floor(x.left, key);
        Node temp = floor(x.right, key);
        if(temp!=null) return temp;
        else return x;
    }

    public Key select(int k){
        return select(root, k).key;
    }
    private Node select(Node x,int k){
        if(x==null) return null;
        int t = size(x.left);
        if(t>k) return select(x.left, k);
        else if(t<k) return select(x.right, k - t - 1);
        else return x;
    }

    public int rank(Key key){
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if(x==null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp<0) return rank(x.left, key);
        else if(cmp>0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }

    public void deleteMin(){
        root=deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x==null) return null;
        if(x.left==null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
        root=delete(root,key);
    }

    private Node delete(Node x, Key key) {
        if(x==null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp<0) x.left=delete(x.left,key);
        else if(cmp>0) x.right = delete(x.right, key);
        else
        {
            if(x.left==null) return x.right;
            if(x.right==null) return x.left;
            Node t = x;
            x = min(x.right);
            x.left = t.left;
            x.right = deleteMin(t.right);
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void print(Node x){
        if(x==null) return;
        print(x.left);
        System.out.println(x.key);
        print(x.right);
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root,queue,lo,hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if(x==null) return;
        int cmpLo = lo.compareTo(x.key);
        int cmpHi = hi.compareTo(x.key);
        if(cmpLo<0) keys(x.left, queue, lo, hi);
        if(cmpLo<=0 && cmpHi>=0) queue.enqueue(x.key);
        if(cmpHi>0) keys(x.right, queue, lo, hi);
    }
}
