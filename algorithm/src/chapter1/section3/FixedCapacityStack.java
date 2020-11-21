package chapter1.section3;

public class FixedCapacityStack<Item>  {
    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

    public boolean isEmpty() {
        return N==0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);
        String[] strings = "to be or not to - be - - that - - - is".split(" ");
        for (int i = 0; i < strings.length; i++) {
            if(!strings[i].equals("-")){
                stack.push(strings[i]);
            }
            else if(!stack.isEmpty()){
                System.out.println(stack.pop()+" ");
            }
        }
        System.out.println(stack.size()+" left on stack");
    }
}
