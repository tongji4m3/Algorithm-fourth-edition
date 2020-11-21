package chapter1.section4;

import chapter1.section1.BinarySearch;

import java.util.Arrays;

public class ThreeSumFast {
    public static int count(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (BinarySearch.rank(-a[i] - a[j], a) > j) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
