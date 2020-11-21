package chapter1.section1;

import java.util.Random;

public class StdRandom {
    private static Random random = new Random();

    //    [a,b)
    public static double uniform(double a, double b) {
        return a + random.nextDouble() * (b - a);
    }

    //    [0,N)
    public static int uniform(int N) {
        return (int) (random.nextDouble() * N);
    }

    public static int uniform(int lo, int hi) {
        return lo + uniform(hi - lo);
    }

    public static void shuffle(double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + StdRandom.uniform(N - i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

}
