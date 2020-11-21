package chapter1.section5;

import chapter1.section4.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeightedQuickUnionUF {

    private int id[];
    private int sz[];
    private int count;

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
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
            p=id[p];
        }
        return p;
    }

    public void union(int p,int q){
        int i = find(p);
        int j = find(q);
        if(i==j){
            return;
        }
        if(sz[i]<sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }
        else{
            id[j] = i;
            sz[i] += sz[j];
        }
        --count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/chapter1/section5/UF.txt"));
        int N = scanner.nextInt();
        WeightedQuickUnionUF quickFindUf = new WeightedQuickUnionUF(N);
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
