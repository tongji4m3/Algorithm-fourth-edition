package chapter2.section4;

import chapter2.section1.Example;

import java.util.Arrays;

public class MaxPQ<Key extends Comparable<Key>> extends Example {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    public boolean less(int v, int w) {
        return pq[v].compareTo(pq[w]) < 0;
    }

    public void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j + 1 <= N && less(j, j + 1)) {
                ++j;
            }
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }
}
