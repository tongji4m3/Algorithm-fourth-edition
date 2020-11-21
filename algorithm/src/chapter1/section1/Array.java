package chapter1.section1;

import java.util.Arrays;

public class Array {
    private double[] a;

    public Array(double[] a) {
        this.a = a;
    }

    public double getMax() {
        double max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public double getAverage() {
        int N = a.length;
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            sum += a[i];
        }
        return sum / N;
    }

    public double[] copy() {
        int N = a.length;
        double[] b = new double[N];
        for (int i = 0; i < N; i++) {
            b[i] = a[i];
        }
        return b;
    }

    public void reverse() {
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            double temp = a[i];
            a[i] = a[N - 1 - i];
            a[N - 1 - i] = temp;
        }
    }
    //方阵相乘
    public static double[][] multipleMatrix(double[][] a, double[][] b) {
        int N = a.length;
        double[][] c = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    //方便获取数组
    public double[] getArray() {
        return a;
    }

    public static void main(String[] args) {
        Array array = new Array(new double[]{1, 3, 5, 7});
        System.out.println(Arrays.toString(array.getArray()));
        array.reverse();
        System.out.println(Arrays.toString(array.getArray()));

        double[][] a = {{2, 2}, {3, 3}};
        double[][] b = {{2, 2}, {3, 3}};
        System.out.println(Arrays.deepToString(multipleMatrix(a,b)));
    }
}
