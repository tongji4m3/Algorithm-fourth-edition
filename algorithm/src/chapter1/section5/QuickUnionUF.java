package chapter1.section5;

import chapter1.section4.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickUnionUF {
    private int[] id;
    private int count;

    public QuickUnionUF(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    public int find(int p){
        while(p!=id[p]){
            p = id[p];
        }
        return p;
    }

    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot) return;
        id[pRoot]=qRoot;
        --count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/chapter1/section5/UF.txt"));
        int N = scanner.nextInt();
        QuickUnionUF quickFindUf = new QuickUnionUF(N);
        Stopwatch stopwatch = new Stopwatch();
        while(scanner.hasNext()){
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if(quickFindUf.connected(p,q)) continue;
            quickFindUf.union(p,q);
        }
        double time = stopwatch.elapsedTime();
        System.out.printf("count is : %d,time is : %.2f", quickFindUf.count,time);
    }
}
