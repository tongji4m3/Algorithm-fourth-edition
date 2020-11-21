package chapter1.section1;

/*
计算两个非负整数p,q的最大公约数:
 */
public class Gcd {
    public static int gcd(int p,int q){
        if(q==0){
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        System.out.println(gcd(10,5));
        System.out.println(gcd(5,0));
        System.out.println(gcd(0,5));
        System.out.println(gcd(11,3));
    }
}
