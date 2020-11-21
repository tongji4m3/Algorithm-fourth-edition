package chapter2.section3;

import chapter2.section1.Example;

import java.util.Arrays;
import java.util.Collections;

public class Quick3way extends Example {
    @Override
    public void sort(Comparable[] a) {
        Collections.shuffle(Arrays.asList(a));
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        Comparable v = a[lo];
        int lt = lo, i = lo + 1, gt = hi;

        while(i<=gt){
            int cmp = a[i].compareTo(v);
            if(cmp<0) exch(a,lt++,i++);
            else if(cmp>0) exch(a,i,gt--);
            else ++i;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }


    public static void main(String[] args) {
        new Quick3way().test();
    }
}
