package chapter1.section3.test;

import chapter1.section3.Queue;
import java.util.*;

public class QueueTest {
    public static int[] readInts(String name) {
        String[] stringInts = name.split(" ");
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < stringInts.length; ++i) {
            queue.enqueue(Integer.parseInt(stringInts[i]));
        }
        int N=queue.size();
        int [] a=new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = queue.dequeue();
        }
        System.out.println(Arrays.toString(a));
        return a;
    }

    public static void main(String[] args) {
        readInts("1 3 4 5 7 8");
    }
}
