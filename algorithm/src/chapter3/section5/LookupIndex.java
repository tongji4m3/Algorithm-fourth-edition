package chapter3.section5;

import chapter1.section3.Queue;

import java.util.HashMap;
import java.util.Scanner;

public class LookupIndex {
    public static void main(String[] args) {
        HashMap<String, Queue<String>> st = new HashMap<>();
        HashMap<String, Queue<String>> ts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String[] strings = scanner.nextLine().split(" ");
            String key = strings[0];
            for (int i = 1; i < strings.length; i++) {

            }
        }
    }
}
