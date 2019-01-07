package com.tongji.algorithms_2_1;

import java.util.Arrays;

import edu.princeton.cs.algs4.Selection;

public class Exe_2_5_17
{
	private static class Test implements Comparable<Test>
	{
		private Comparable c;
		private int i;
		public Test(Comparable c,int i)
		{
			this.c=c;
			this.i=i;
		}
		public int compareTo(Test that)
		{
			return this.c.compareTo(that.c);
		}
		public String toString()
		{
			return c+" "+i;
		}
	}
	public static boolean check(Comparable [] a)
	{
		Test [] temp=new Test [a.length];
		for (int i = 0; i < a.length ; i++) 
		{
			temp[i]=new Test(a[i],i);
		}
//		Arrays.sort(temp);
		Selection.sort(temp);
//		for (int i = 0; i < a.length ; i++) 
//		{
//			System.out.println(temp[i]);
//		}
		for (int i = 1; i < a.length ; i++) 
		{
			if(temp[i].c.compareTo(temp[i-1].c)==0 && temp[i].i<temp[i-1].i)//如果有重复的,并且顺序不对的,返回false
				return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		Integer [] a= {5,8,3,9,2,9,1,9};
		System.out.println(check(a));
	}
}
