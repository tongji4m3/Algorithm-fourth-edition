package com.tongji.test_1_4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;

public class Exe_2_3_20
{
	public static void sort(Comparable [] a)
	{
		if(a==null || a.length<=0)
			return;
		Stack<Integer> loStack=new Stack<>();
		Stack<Integer> hiStack=new Stack<>();
		int lo=0;
		int hi=a.length-1;
		int pos;
		
		loStack.push(lo);
		hiStack.push(hi);
		while(!loStack.isEmpty())
		{
			lo=loStack.pop();
			hi=hiStack.pop();
			pos=partition(a, lo, hi);
			if(lo<pos-1)//类似于if(hi<=lo) break; 只有一个元素的时候就停止递归了
			{
				loStack.push(lo);
				hiStack.push(pos-1);
			}
			if(hi>pos+1)
			{
				loStack.push(pos+1);
				hiStack.push(hi);
			}
		}
	}
	public static int partition(Comparable [] a,int lo,int hi)
	{
		int i=lo;
		int j=hi+1;
		Comparable v=a[lo];
		while(true)
		{
			while(less(a[++i],v)) if(i==hi) break;
			while(less(v,a[--j])) if(j==lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
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
	private static void print(Comparable [] a)
	{
		for (int i = 0; i <a.length ; i++) 
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		int N=10;
		Integer [] a=new Integer[10];
		for (int i = 0; i <N ; i++) 
		{
			a[i]=StdRandom.uniform(20);
		}
		sort(a);
		print(a);
	}
}
 
	
