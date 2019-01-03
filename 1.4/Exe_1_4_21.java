package com.tongji.test_1_4;

import java.util.Arrays;

import com.tongji.algorithms_1_4.StaticSETofInts;

public class Exe_1_4_21
{
	private int[] a;

	public Exe_1_4_21(int[] keys)
	{
		a = new int[keys.length];
		for (int i = 0; i < keys.length; i++)
			a[i] = keys[i];
		Arrays.sort(a);
	}

	public boolean contains(int key)
	{
		return rank(key) != -1;
	}


	public int rank(int key)
	{
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
			{
				return mid;
			}
		}
		return -1;
	}
	public static void main(String[] args)
	{
		int [] keys= {2,1,3,5,4};
		StaticSETofInts s=new StaticSETofInts(keys);
		System.out.println(s.contains(3));
	}
}
