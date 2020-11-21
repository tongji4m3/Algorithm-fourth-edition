package chapter1.section2;

public class Counter {
    private final String name;
    private int count;

    public Counter(String name) {
        this.name = name;
    }

    public void increment(){
        ++count;
    }
    public int tally(){
        return count;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        heads.increment();
        heads.increment();
        tails.increment();

        System.out.println(heads+" "+tails);
        System.out.println(heads.tally()+" "+tails.tally());
    }
}
