package chapter1.section1;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        double sum = 0.0;
        int cnt = 0;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            sum += scanner.nextDouble();
            ++cnt;
        }
        double avg = sum / cnt;
        System.out.printf("Average is %.5f\n",avg);
        //ctrl + D结束输入
    }
}
