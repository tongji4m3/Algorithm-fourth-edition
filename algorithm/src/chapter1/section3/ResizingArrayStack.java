package chapter1.section3;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public void push(Item item) {
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if(N>0 && N==a.length/4) resize(a.length/2);
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>(){

            private int i = N;

            @Override
            public boolean hasNext() {
                return i>0;
            }

            @Override
            public Item next() {
                return a[--i];
            }
        };
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        for (String s : "1 3 4 5 7 8".split(" ")) {
            stack.push(s);
        }
        for (String s : stack) {
            System.out.println(s);
        }

        /*
        Iterator<String> iterator = stack.iterator();
        iterator.remove();
        //UnsupportedOperationException
        */
    }
}
