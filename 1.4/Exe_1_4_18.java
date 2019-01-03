package com.tongji.test_1_4;

import java.util.Random;

import edu.princeton.cs.algs4.StdRandom;

public class Exe_1_4_18
{
	public static void main(String[] args)
	{
		int N=10;
		int [] a=new int[N];
		for (int i = 0; i <N ; i++) 
		{
			a[i]=i;
		}
		StdRandom.shuffle(a);
		for (int i = 0; i <N ; i++) 
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
		int i=find(a);
		System.out.println(i);
	}
	public static int find(int [] a)
	{
		return find(a,0,a.length-1);
	}
	public static int find(int [] a,int lo,int hi)
	{
		int mid=lo+(hi-lo)/2;
		if(a[mid]<a[mid-1]&&a[mid]<a[mid+1])
			return mid;
		//在较小的相邻元素的半边中继续查找 (不是很懂为什么)
		if(a[mid-1]<a[mid+1])
			return find(a,lo,mid-1);
		else 
			return find(a,mid+1,hi);
	}
}
