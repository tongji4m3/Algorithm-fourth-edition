package chapter1.section2;

import java.util.Arrays;

public class StaticSETofInts {
    private int[] a;

    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }

    public boolean contains(int key){
        return rank(key) != -1;
    }

    private int rank(int key) {
        int lo = 0, hi = a.length - 1;
        while(lo<=hi){
            int mid = lo + (hi - lo) / 2;
            if(key<a[mid]) hi = mid - 1;
            else if(key>a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = {1, 2, 5, 4, 9, 3};
        StaticSETofInts set = new StaticSETofInts(whitelist);
        System.out.println(set.contains(6));
    }
}
