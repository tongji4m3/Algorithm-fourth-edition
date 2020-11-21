package chapter1.section3.test;

import chapter1.section3.Stack;

public class Reverse {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String s : "1 3 4 5 7 8".split(" ")) {
            stack.push(s);
        }
        for (String s : stack) {
            System.out.println(s);
        }
    }
}
