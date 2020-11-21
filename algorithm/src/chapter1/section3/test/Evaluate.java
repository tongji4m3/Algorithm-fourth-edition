package chapter1.section3.test;

import chapter1.section3.ResizingArrayStack;
import chapter1.section3.Stack;

public class Evaluate {
    public static void main(String[] args) {
        ResizingArrayStack<String> ops = new ResizingArrayStack<>();
        ResizingArrayStack<Double> vals = new ResizingArrayStack<>();
        String evaluate = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String[] strings = evaluate.split(" ");
        for (String s : strings) {
            if (s.equals("(")) {

            }
            else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
                ops.push(s);
            }
            else if (s.equals(")")) {
                String op = ops.pop();
                double val = vals.pop();
                if(op.equals("+")) val = vals.pop() + val;
                else if(op.equals("-")) val = vals.pop() - val;
                else if(op.equals("*")) val = vals.pop() * val;
                else if(op.equals("/")) val = vals.pop() / val;
                else if(op.equals("sqrt")) val = Math.sqrt(val);
                vals.push(val);
            }
            else{
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());
    }
}
