package chapter2.section1;

public class Shell extends Example {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        //1,4,13,40
        //假如N=100,则h=40,开始则基本以三个为一组进行选择排序
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j - h >= 0 && less(a[j],a[j-h]); j -= h) {
                    exch(a,j,j-h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        new Shell().test();
    }
}
