package chapter3.section5;

import java.util.HashSet;

public class DeDup {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        String[] strings = "it was the best things that I never never known".split(" ");
        for (int i = 0; i < strings.length; i++) {
            String word = strings[i];
            if (!hashSet.contains(word)) {
                hashSet.add(word);
                System.out.println(word);
            }
        }
    }
}
