package chapter3.section1;

import chapter1.section3.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> extends ST<Key,Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        if(i<N && keys[i].compareTo(key)==0){
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[N-1];
    }


    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }
        if(contains(hi)){
            queue.enqueue(keys[rank(hi)]);
        }
        return queue;
    }

    @Override
    public Key ceiling(Key key) {
        return keys[rank(key)];
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    public int rank(Key key, int lo, int hi){
        if(hi<lo) return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp<0) return rank(key, lo, mid - 1);
        else if(cmp>0) return rank(key, mid + 1, hi);
        else return mid;
    }

    @Override
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while(lo<=hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp<0) hi = mid - 1;
            else if(cmp>0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    @Override
    public Value get(Key key) {
        if(isEmpty()) return null;
        int i = rank(key);
        if(i<N && keys[i].compareTo(key)==0) return values[i];
        else return null;
    }

    @Override
    public int size() {
        return N;
    }
}
