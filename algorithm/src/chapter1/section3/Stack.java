package chapter1.section3;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack() {

    }

    public void push(Item item) {
        first = new Node(item, first);
        ++N;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        --N;
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
        Node temp = first;
        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return first!=null;
            }

            @Override
            public Item next() {
                Item item = first.item;
                first = first.next;
                return item;
            }
        };
    }
}
