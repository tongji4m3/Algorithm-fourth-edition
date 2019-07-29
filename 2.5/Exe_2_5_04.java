package com.tongji.algorithms_2_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import edu.princeton.cs.algs4.Queue;

public class Exe_2_5_4
{
	public static String [] dedup(String [] a)
	{
		Arrays.sort(a);
		Queue<String> queue=new Queue<>();
		queue.enqueue(a[0]);
		for (int i = 1; i <a.length ; i++) 
		{
			if(a[i].compareTo(a[i-1])!=0)
				queue.enqueue(a[i]);
		}
		String [] temp=new String[queue.size()];
		for (int i = 0; i < temp.length ; i++) 
		{
			temp[i]=queue.dequeue();
		}
		return temp;
	}
	public static void main(String[] args)
	{
		String [] strings="after thought afterthought ab cd abcd a a aaa aa aa".split(" ");
		for(String s:dedup(strings))
		{
			System.out.print(s+" ");
		}
	}
}
