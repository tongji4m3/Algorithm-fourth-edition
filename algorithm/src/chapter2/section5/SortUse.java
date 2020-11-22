package chapter2.section5;

import java.util.Arrays;
import java.util.Collections;

public class SortUse {
    public static void unRepeatCount(Comparable [] a){
        Arrays.sort(a);
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if(a[i].compareTo(a[i-1])!=0){
                ++count;
            }
        }
    }

    public static Comparable select(Comparable [] a,int k){
        Collections.shuffle(Arrays.asList(a));
        int lo = 0, hi = a.length - 1;
        while(hi>lo){
            int j = partition(a, lo, hi);
            if(j==k) return a[k];
            else if(j>k) hi = j - 1;
            else if(j<k) lo = j + 1;
        }
        return a[k];
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a,lo,j);
        return j;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
