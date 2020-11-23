package chapter3.section1;

import chapter3.section2.BST;

public class FrequencyCounter {
    public static void main(String[] args) {
        int minLen = 3;
        BST<String, Integer> st = new BST<>();
        String[] strings = "it was the best things that I never never known".split(" ");
        for (int i = 0; i < strings.length; i++) {
            String word = strings[i];
            if (word.length() < minLen) {
                continue;
            }

            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }

        String max = " ";
        st.put(max, 0);
        for (String key : st.keys()) {
            if (st.get(key) > st.get(max)) {
                max = key;
            }
        }
        System.out.println(max + " " + st.get(max));
    }
}
