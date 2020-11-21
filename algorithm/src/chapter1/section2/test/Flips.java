package chapter1.section2.test;


import chapter1.section2.Counter;

import java.util.Random;

public class Flips {
    public static void main(String[] args) {
        int T = 10000;
        Random random = new Random();

        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int i = 0; i < T; i++) {
            if(random.nextDouble()<0.5){
                heads.increment();
            }
            else{
                tails.increment();
            }
        }
        System.out.println(heads);
        System.out.println(tails);
        System.out.println(Math.abs(heads.tally()-tails.tally()));
    }
}
