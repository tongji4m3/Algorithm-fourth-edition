package com.tongji.algorithms_2_1;

import edu.princeton.cs.algs4.StdRandom;

public class Exe_2_5_6
{
	public static Comparable select(Comparable [] a,int k)
	{
		StdRandom.shuffle(a);
		return select(a, k,0,a.length-1);
	}
	public static Comparable select(Comparable [] a,int k,int lo,int hi)
	{
		if(lo>=hi)
			return a[k];
		int j=partition(a,lo,hi);
		if(j==k)
			return a[k];
		else if(j>k)
			return select(a, k,lo,j-1);
		else if(j<k)
			return select(a, k, j+1, hi);
	}
}
