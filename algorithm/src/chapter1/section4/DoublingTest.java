package chapter1.section4;

import java.util.Random;

public class DoublingTest {
    public static double timeTrial(int N){
        int[] a = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt(1000) - 500;
        }
        Stopwatch stopwatch = new Stopwatch();
        int cnt = ThreeSumFast.count(a);
//        int cnt = ThreeSum.count(a);
//        int cnt = TwoSumFast.count(a);
        double time = stopwatch.elapsedTime();
        return time;

    }

    public static void main(String[] args) {
        for (int N = 250;; N*=2) {
            System.out.printf("N is %d,time is : %.2f\n",N,timeTrial(N));
        }
    }
}
