package chapter1.section2.test;

import chapter1.section2.Counter;

import java.util.Random;

public class FlipsMax {
    public static Counter max(Counter x, Counter y){
        if(x.tally()>y.tally()) return x;
        else return y;
    }

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
        if(heads.tally()==tails.tally()) System.out.println("equals");
        else System.out.println(max(heads,tails)+" win");
    }
}
