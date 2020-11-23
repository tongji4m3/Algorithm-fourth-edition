package chapter3.section4;

import chapter3.section1.SequentialSearchST;

public class SeparateChainingHashST<Key extends Comparable<Key>,Value> {
    private int N;
    private int M;

    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    public SeparateChainingHashST() {
        this(997);
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff & M);
    }

    public Value get(Key key){
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key,Value value){
        st[hash(key)].put(key, value);
    }
}
