package com.tongji.test_1_4;

import edu.princeton.cs.algs4.StdOut;

public class Exe_2_3_16
{
	private static void best(int [] a,int lo,int hi)
	{
		//相当于快排的逆过程,每次都放中间点在第一个元素
		for (int i = lo; i <=hi ; i++) 
		{
			assert a[i]==i;
		}
		if(hi<=lo)
			return;
		int mid=lo+(hi-lo)/2;
		best(a, lo, mid-1);
		best(a, mid+1, hi);
		exch(a,lo,mid);
		//最后交换最中间的,就是因为sort里面第一个交换中间的
	}
	public static int [] best(int n)
	{
		int [] a=new int[n];
		for (int i = 0; i <n ; i++) 
		{
			a[i]=i;
		}
		best(a,0,n-1);
		return a;
	}
	private static void exch(int [] a,int i,int j)
	{
		int swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
	public static void main(String[] args) {
		String alphabet = "ABCDEFG";
		int n = 7;
		int[] a = best(n);
		for (int i = 0; i < n; i++)
		{
			StdOut.print(alphabet.charAt(a[i]));
			//DACBFEG
			//先是BAC D FEG  然后D和B交换得到结果
		}
		StdOut.println();
	}
}
