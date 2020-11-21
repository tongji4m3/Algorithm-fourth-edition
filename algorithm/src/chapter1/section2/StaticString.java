package chapter1.section2;

import java.util.Scanner;

//典型的字符串处理代码
public class StaticString {
    //判断是否是回文
    public static boolean isPalindrome(String s) {
        int N = s.length();
        for (int i = 0; i < N / 2; i++) {
            if (s.charAt(i) != s.charAt(N - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    //提取文件名,扩展名
    public static String getFileName(String s) {
        int dot = s.indexOf(".");
        String base = s.substring(0, dot);
        String extension = s.substring(dot + 1);
        System.out.println(base);
        System.out.println(extension);
        return base;
    }

    //打印输入中含有query的行
    public static void printQueryLine() {
        Scanner scanner = new Scanner(System.in);
        String query = "abc";
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.contains(query)) {
                System.out.println(line);
            }
        }
    }


    public static boolean isSorted(String [] a){
        for (int i = 1; i < a.length; i++) {
            if(a[i-1].compareTo(a[i])>0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        getFileName("file.txt");
        printQueryLine();
    }

}
