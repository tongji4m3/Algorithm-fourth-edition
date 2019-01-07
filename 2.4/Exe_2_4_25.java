package com.tongji.algorithms_1_5;

import edu.princeton.cs.algs4.MinPQ;

public class Exe_2_4_25 implements Comparable<Exe_2_4_25>
{
	private final int sum;
	private final int i;
	private final int j;
	
	public Exe_2_4_25(int i,int j)
	{
		this.sum=i*i*i+j*j*j;
		this.i=i;
		this.j=j;
	}
	public int compareTo(Exe_2_4_25 that)
	{
		if(this.sum<that.sum)
			return -1;
		if(this.sum>that.sum)
			return +1;
		return 0;
	}
	public String toString()
	{
		return sum+" = "+i+"^3"+" + "+j+"^3";
	}
	public static void main(String[] args)
	{
		int N=5;
		MinPQ<Exe_2_4_25> pq=new MinPQ<>();
		for (int i = 0; i <=N ; i++) 
		{
			pq.insert(new Exe_2_4_25(i, i));
		}
		while(!pq.isEmpty())
		{
			Exe_2_4_25 s=pq.delMin();
			System.out.println(s);
			//因为i相同,j不同时,j越大数就越大,所以先对相同的j(初始为0),不同的i进行比较
			//然后一个(i,j)走了,在加入这个i的下一个j
			if(s.j<N)
				pq.insert(new Exe_2_4_25(s.i, s.j+1));
		}
	}
}



