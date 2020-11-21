package chapter1.section2;

import java.util.Random;

public class Accumulator {
    private double total;
    private int N;

    public void addDataValue(double val){
        ++N;
        total += val;
    }

    public double mean(){
        return total / N;
    }

    @Override
    public String toString() {
        return "Accumulator{" +
                "total=" + total +
                ", N=" + N +
                '}';
    }

    public static void main(String[] args) {
        int T = 100;
        Accumulator accumulator = new Accumulator();
        Random random = new Random();

        for (int i = 0; i < T; i++) {
            accumulator.addDataValue(random.nextDouble());
        }

        System.out.println(accumulator);
        System.out.println(accumulator.mean());
    }
}
