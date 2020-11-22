package chapter2.section5;

import java.util.Comparator;

public class Transaction {
    private final String who;
    private final String when;
    private final double amount;

    public Transaction(String who, String when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public static class WhoOrder implements Comparator<Transaction>{
        public int compare(Transaction v,Transaction w){
            return v.who.compareTo(w.who);
        }
    }

    public static class WhenOrder implements Comparator<Transaction>{
        public int compare(Transaction v,Transaction w){
            return v.when.compareTo(w.when);
        }
    }

    public static class HowMuchOrder implements Comparator<Transaction>{

        @Override
        public int compare(Transaction v, Transaction w) {
            if(v.amount<w.amount) return -1;
            else if(v.amount>w.amount) return +1;
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "who='" + who + '\'' +
                ", when='" + when + '\'' +
                ", amount=" + amount +
                '}';
    }
}
