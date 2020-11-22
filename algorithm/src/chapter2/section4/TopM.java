package chapter2.section4;

import java.util.Random;

public class TopM {
    public static void main(String[] args) {
        int N = 10;
        MaxPQ<Integer> maxPQ = new MaxPQ<>(N+1);
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            maxPQ.insert(random.nextInt(10000));
            if(maxPQ.size()>N) maxPQ.delMax();
        }
        for (int i = 0; i < maxPQ.size(); i++) {
            System.out.println(maxPQ.delMax());
        }
    }
}
