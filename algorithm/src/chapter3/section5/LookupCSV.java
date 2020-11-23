package chapter3.section5;

import chapter3.section4.SeparateChainingHashST;

import java.util.Scanner;

public class LookupCSV {
    public static void main(String[] args) {
        SeparateChainingHashST<String, String> st = new SeparateChainingHashST<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(",");
            String key = tokens[0];
            String value = tokens[1];
            st.put(key,value);
        }

        String query = "hello";
        System.out.println(st.get(query));
    }
}
