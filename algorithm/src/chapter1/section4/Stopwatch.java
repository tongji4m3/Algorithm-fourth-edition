package chapter1.section4;

import java.util.Random;

public class Stopwatch {
    private final long start;

    public Stopwatch() {
        this.start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        int N = 30000000;
        int[] a = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt(1000) - 500;
        }
        Stopwatch stopwatch = new Stopwatch();
//        int cnt = ThreeSum.count(a);
        int cnt = TwoSumFast.count(a);
        double time = stopwatch.elapsedTime();
        System.out.printf("cnt is : %d,time is : %.2f",cnt,time);
    }
}
