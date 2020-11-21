package chapter1.section3.test;

import chapter1.section3.Bag;

import java.util.*;

public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        Random random = new Random();
        for (int i = 0; i < 10; ++i) {
            numbers.add(random.nextDouble());
        }
        int N = numbers.size();

        double sum = 0.0;
        for(double x:numbers){
            sum += x;
        }
        double mean = sum / N;
        System.out.println("mean is "+mean);
    }
}
