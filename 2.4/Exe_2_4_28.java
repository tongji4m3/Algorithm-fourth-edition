package com.tongji.algorithms_1_5;

import java.util.Random;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

public class Exe_2_4_28 implements Comparable<Exe_2_4_28>
{
	private int x,y,z;
	private double distance;
	
	public Exe_2_4_28(int x,int y,int z)
	{
		this.x=x;
		this.y=y;
		this.z=z;
		this.distance=Math.sqrt(x*x+y*y+z*z);
	}
	public int compareTo(Exe_2_4_28 that)
	{
		return Double.compare(this.distance, that.distance);
	}
	public String toString()
	{
		return "(" + this.x + ", " + this.y + ", " + this.z + ")";
	}
	public static void main(String[] args)
	{
		int N=20;
		int M=5;
		MaxPQ<Exe_2_4_28> pq=new MaxPQ<>(M+1);
		Random random=new Random();
		for (int i = 0; i < N; i++) 
		{
			pq.insert(new Exe_2_4_28(random.nextInt(10), random.nextInt(10), random.nextInt(10)));
			if(pq.size()>M)
				pq.delMax();
		}
		Stack<Exe_2_4_28> stack=new Stack<>();
		while(!pq.isEmpty())
			stack.push(pq.delMax());
		for(Exe_2_4_28 e:stack)
			System.out.println(e);

	}
}
