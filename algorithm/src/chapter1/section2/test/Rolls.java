package chapter1.section2.test;

import chapter1.section2.Counter;

import java.util.Random;

public class Rolls {
    public static void main(String[] args) {
        int T = 1000;
        int SIDES = 6;
        Random random = new Random();
        Counter[] rolls = new Counter[SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            rolls[i] = new Counter(i + "s");
        }
        for (int i = 0; i < T; i++) {
            rolls[random.nextInt(6) + 1].increment();
        }
        for (int i = 1; i <= SIDES; i++) {
            System.out.println(rolls[i]);

        }
    }
}
