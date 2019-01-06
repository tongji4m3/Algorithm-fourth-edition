package com.tongji.test_1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Exe_2_3_17
{
	//有个小问题,子数组的右侧元素怎么避免检测
	//答案是:在处理内部子数组的时候，右子数组中最左侧的元素可以作为左子数组右边界的哨兵
	//其实就是如果i++到hi+1时,其实就到了切分元素j上面了,肯定比切分元素小!
	public static void sort(Comparable [] a)
	{
		StdRandom.shuffle(a);
		int temp=0;
		for (int i = 1; i <a.length ; i++) 
		{
			if(less(a[i],a[temp]))
				temp=i;
		}
		exch(a, temp, a.length-1);
		sort(a,0,a.length-1);
	}
	private static void sort(Comparable [] a,int lo,int hi)
	{
		if(hi<=lo)
			return;
		int j=partition(a, lo, hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	private static int partition(Comparable [] a,int lo,int hi)
	{
		int i=lo;
		int j=hi+1;
		Comparable v=a[lo];
		while(true)
		{
			while(less(a[++i], v));
			while(less(v,a[--j]));
			if(j>i)
				exch(a, i, j);
			else
				break;
		}
		exch(a, lo, j);
		return j;
	}

	private static boolean less(Comparable v,Comparable w)
	{
		return v.compareTo(w)<0;
	}
	private static void exch(Comparable [] a,int i,int j)
	{
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void show(Comparable [] a)
	{
		for (int i = 0; i < a.length; i++) 
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static boolean isSorted(Comparable [] a)
	{
		for (int i = 1; i <a.length ; i++) 
		{
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		String [] a=In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}

