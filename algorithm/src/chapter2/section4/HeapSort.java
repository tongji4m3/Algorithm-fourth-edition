package chapter2.section4;

import java.util.Arrays;

public class HeapSort {
    public static void sort(Comparable[] a) {
        //因为只能排序a数组的[1,N-1]处,所以特殊处理
        int N = a.length;
        Comparable[] temp = new Comparable[N + 1];
        System.arraycopy(a,0,temp,1,a.length);

        //构造堆
        for (int k = N / 2; k >= 1; k--) {
            //使用修改过的sink,主要是这里和前面的一个个的构造堆有点区别
            sink(temp,k,N);
        }
        //排序
        while(N>1){
            exch(temp,1,N--);
            sink(temp,1,N);
        }
        System.out.println(Arrays.toString(temp));
        System.arraycopy(temp,1,a,0,a.length);
        System.out.println(Arrays.toString(a));
    }
    
    private static void sink(Comparable[] a, int k, int N) {
        while(2*k<=N){
            int j = 2 * k;
            if(j+1<=N && less(a[j],a[j+1])) ++j;
            if(less(a[j],a[k])) break;
            exch(a,j,k);
            k = j;
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 5, 4, 9, 3, 1, 2, 3, 7};
        sort(a);
    }
}
