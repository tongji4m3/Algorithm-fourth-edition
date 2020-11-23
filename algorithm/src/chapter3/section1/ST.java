package chapter3.section1;

import chapter3.section2.BST;

import java.util.Random;

public class ST<Key extends Comparable<Key>, Value> {
    public ST() {
    }

    public void put(Key key, Value value) {
        if (value == null) {
            delete(key);
            return;
        }
    }

    public Value get(Key key) {
        return null;
    }

    public void delete(Key key) {
        put(key, null);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Key min() {
        return null;
    }

    public Key max() {
        return null;
    }

    //向下取整
    public Key floor(Key key){
        return null;
    }

    public Key ceiling(Key key){
        return null;
    }

    public int rank(Key key){
        return 0;
    }

    public Key select(int k){
        return null;
    }

    public void deleteMin(){
        delete(min());
    }

    public void deleteMax(){
        delete(max());
    }

    public int size(Key lo,Key hi){
        if(hi.compareTo(lo)<0)
            return 0;
        else if(contains(hi))
            return rank(hi) - rank(lo) + 1;
        else
            return rank(hi) - rank(lo);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo,Key hi) {
        return null;
    }

    public static void main(String[] args) {
        BST<String, Integer> st = new BST<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char ch = (char)(random.nextInt(26) + 'A');
            st.put(ch+"",i);
        }
        for (String key : st.keys()) {
            System.out.println(key+" "+st.get(key));
        }
    }
}
