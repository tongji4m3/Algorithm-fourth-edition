package chapter1.section4;

import chapter1.section1.BinarySearch;

import java.util.Arrays;

public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            //不能与自身匹配,也不能与前面的匹配
            if (BinarySearch.rank(-a[i], a) > i) {
                ++cnt;
            }
        }
        return cnt;
    }

}
