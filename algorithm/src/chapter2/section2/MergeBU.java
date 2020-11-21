package chapter2.section2;

import chapter2.section1.Example;

public class MergeBU extends Example {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz*=2) {
            for (int lo = 0; lo < N - sz; lo+=2*sz) {
                merge(a,lo,lo+sz-1,Math.min(lo+2*sz-1,N-1));
            }
        }
    }

    private static Comparable[] aux;
    public void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if(i>mid) a[k] = aux[j++];
            else if(j>hi) a[k] = aux[i++];
            else if(less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

    }
}
