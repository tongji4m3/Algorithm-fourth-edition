package chapter2.section5;

import java.util.Arrays;
import java.util.Comparator;

public class Insertion {
    public static<T> void sort(T[] a, Comparator<T> c) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j - 1 >= 0 && less(c, a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static<T> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static<T> boolean less(Comparator<T> c, T v, T w) {
        return c.compare(v, w) < 0;
    }

    public static void main(String[] args) {
        Transaction[] a = new Transaction[3];
        a[0] = new Transaction("A", "C", 300);
        a[1] = new Transaction("B", "B", 100);
        a[2] = new Transaction("C", "A", 200);

        Insertion.sort(a,new Transaction.WhenOrder());
        System.out.println(Arrays.toString(a));

    }
}
