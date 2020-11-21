package chapter1.section1;

public class StaticMethod {
    public static int abs(int x) {
        if (x < 0) return -x;
        else return x;
    }

    public static double abs(double x) {
        if (x < 0) return -x;
        else return x;
    }

    //判断是否是素数
    public static boolean isPrime(int N) {
        if (N < 2) return false;
        /*
        i * i <= N : 只需要判断[2,根号N],之间的数是否能被N整除即可
        因为如果N能被[2,N-1]的任意一个数整除,则其中必然有一个因子位于[2,根号N]之间
        例如11,会判断2,3
         */
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) return false;
        }
        return true;
    }

    //牛顿迭代法求平方根
    /*
    求c的平方根,即求f(x)=x^2-c=0(c>0) 的正根 其中f'(x)=2*x
    找f(x)上一点(x0,f(x0)),方程为 y-f(x0)=f'(x0)(x-x0)
    设与x轴交点为(x1,0),则f(x0)+2x0(x1-x0)=0,所以x1=x0-f(x0)/(2x0)

    例如求5的平方根,初始化x0=5,找出(5,20)的切线与x轴的交点x1(3),再把该x1赋值给x0
    这时,继续找到x0对应的f(x):(3,4)的切线,与x轴交与(x1,0)...
    不断计算,逼近曲线与x轴的交点,即结果
     */
    public static double sqrt(double c) {
        if (c < 0) return Double.NaN;
        double err = 1e-15;
        double x0 = c;

        while (Math.abs(x0 - c / x0) > err * x0) {
            x0 = (c / x0 + x0) / 2.0;
        }
        return x0;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(3));
        System.out.println(sqrt(0));
    }
}
