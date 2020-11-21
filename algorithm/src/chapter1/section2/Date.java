package chapter1.section2;

public class Date {
    private final int month;
    private final int day;
    private final int year;

    @Override
    public String toString() {
        return "Date{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public boolean equals(Object x){
        if(this==x) return true;
        if(x==null) return false;
        if(this.getClass()!=x.getClass()) return false;
        Date that = (Date) x;
        if(this.day!=that.day) return false;
        if(this.month!=that.month) return false;
        if(this.year!=that.year) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Date(12,31,2020));
    }
}
