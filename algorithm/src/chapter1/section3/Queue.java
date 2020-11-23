package chapter1.section3;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private Node first, last;
    private int N;

    private class Node {
        Item item;
        Node next;

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Queue() {
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node(item, null);
        if (first == null) first = last;
        else oldLast.next = last;
        ++N;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if(first==null) last = null;
        --N;
        return item;
    }

    public boolean isEmpty() {
        return first==null;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node temp=first;
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
