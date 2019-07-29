package com.tongji.test_1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exe_2_3_18
{
	public static void sort(Comparable [] a)
	{
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable [] a,int lo,int hi)
	{
		if(hi<=lo)
		{
			return;
		}
		
		int j=partition(a, lo, hi);
		sort(a,lo,j-1);
		sort(a, j+1, hi);
		
	}
	
	private static int partition(Comparable [] a,int lo,int hi)
	{
		exch(a, lo, threeQuick(a, lo, hi));
		int i=lo,j=hi+1;
		Comparable v=a[lo];
		while(true)
		{
			while(less(a[++i], v))
			{
				if(i==hi)
				{
					break;
				}
			}
			while(less(v, a[--j]))
			{
				if(j==lo)
				{
					break;
				}
			}
			if(i>=j)
			{
				break;
			}
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	private static int threeQuick(Comparable [] a,int lo,int hi)
	{
		if((hi-lo+1)<3)
		{
			return lo;
		}
		if(less(a[lo], a[lo+1]) && less(a[lo+1], a[lo+2]))
		{
			return lo+1;
		}
		else if(less(a[lo+1], a[lo]) && less(a[lo], a[lo+2]))
		{
			return lo;
		}
		else
		{
			return lo+2;
		}
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
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
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
