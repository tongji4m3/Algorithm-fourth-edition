package chapter2.section1;

import chapter1.section4.Stopwatch;

import java.util.Random;

public class Example {
    public void sort(Comparable[] a) {

    }

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public void test() {
        int N = 3000000;
        Integer[] a = new Integer[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt(100000);
        }
        Stopwatch stopwatch = new Stopwatch();
        sort(a);
        double time = stopwatch.elapsedTime();
        System.out.printf("time is : %.2f\n", time);
        assert isSorted(a);
        show(a);
    }
}
