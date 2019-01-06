package com.tongji.test_1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exe_2_3_19
{
	public static void sort(Comparable[] a)
	{
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi)
	{
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi)
	{
		int i = lo;
		int j = hi + 1;
		int index = fiveQuick(a, lo, hi);
		exch(a, lo, index);
		Comparable v = a[lo];
		while (true)
		{
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	private static int fiveQuick(Comparable [] a,int lo,int hi)
	{
		int sonLength=hi-lo+1;
		if(sonLength<5)
			return lo;
		Integer [] b=new Integer[5];
		if(sonLength==5)
		{
			for (int i = 0; i <b.length ; i++) 
			{
				b[i]=lo+i;
			}
		}
		else
		{
			for (int i = 0; i <b.length ; i++) 
			{
				//随机抽取子数组的五个元素
				b[i]=StdRandom.uniform(lo,hi+1);
			}
		}
		for (int i = 1; i < b.length ; i++) 
		{
			//b中 0,1,2,3,4可能对应着a中元素的1,2,5,4,9,而a中的1索引可能对应着lucy
			for (int j = i; j >0 && less(a[b[j]], a[b[j-1]]) ; j--) 
			{
				exch(b, j, j-1);
			}
		}
		return b[2];
	}

	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j)
	{
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a)
	{
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a)
	{
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		int N = 10;
		Integer [] a = new Integer[N];
		for (int k = 0; k < N; k++)
			a[k] = StdRandom.uniform(20);

		sort(a);
		assert isSorted(a);
		show(a);
	}
}
