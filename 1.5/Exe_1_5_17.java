package com.tongji.algorithms_1_5;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class Exe_1_5_17
{
	public static void main(String[] args)
	{
		int N=Integer.parseInt(args[0]);
		int trials=Integer.parseInt(args[1]);
		int [] edges=new int[trials];
		//重复做trials次试验
		for (int i = 0; i <trials ; i++) 
		{
			edges[i]=count(N);
		}
		System.out.println("mean :"+StdStats.mean(edges));

	}
	public static int count(int N)
	{
		//尝试连接的次数
		int edges=0;
		UF uf=new UF(N);
		while(uf.count()>1)
		{
			int i=StdRandom.uniform(N);
			int j=StdRandom.uniform(N);
			uf.union(i, j);
			edges++;
		}
		return edges;
	}
}


