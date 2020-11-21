package chapter1.section3;

import java.util.Iterator;
import java.util.Random;

public class Bag<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    private class Node{
        Item item;
        Node next;

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Bag() {

    }

    public void add(Item item){
        first = new Node(item, first);
        ++N;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public int size(){
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        Random random = new Random();
        for (int i = 0; i < 10; ++i) {
            numbers.add(random.nextDouble());
        }
        for (Double number : numbers) {
            System.out.printf("%-5.2f",number);
        }
    }
}
