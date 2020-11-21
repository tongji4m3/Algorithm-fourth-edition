package chapter1.section1;

import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = {1, 2, 5, 4, 9, 3};
        Arrays.sort(whitelist);
        int key = 7;
        //过滤掉所有存在与白名单里的
        //找不到则打印出来,意思是不在白名单里
        if (rank(key, whitelist) == -1) {
            System.out.println(key);
        }

    }
}
