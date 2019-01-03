package com.tongji.test_1_4;

import java.util.Arrays;

public class Exe_1_4_22
{
	public static void main(String[] args)
	{
		int N=10;
		int [] a=new int[N];
		for (int i = 0; i <N ; i++) 
		{
			a[i]=i;
		}
		Arrays.sort(a);
		System.out.println(rank(9,a));
	}
	public static boolean rank(int key,int [] a)
	{
		//利用斐波那契数列来做 1 1 2 3 5...
		int f1=1;
		int f2=1;
		//直到a.length在f1与f2之间
		while(f2<=a.length)
		{
			int temp=f2;
			f2=f1+f2;
			f1=temp;
		}
		int lo=0;
		int hi=a.length-1;
		while(lo<=hi)
		{
			int mid=lo+f2-f1-1;
			if(a[mid]==key)
				return true;
			else if(a[mid]>key)
			{
				hi=lo+f2-f1;
				f2=f2-f1;
				f1=f1-f2;
				//f1,f2往前挪
			}
			else
			{
				hi=Math.min(hi, lo+f2);
				lo=lo+f2-f1;
				int temp=f1;
				f1=f2-f1;
				f2=temp;
			}
		}
		return false;
	}
}
