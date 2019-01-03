package com.tongji.test_1_4;

import java.util.Arrays;
import java.util.Random;

import com.tongji.algorithms_1_4.BinarySearch;

public class Exe_1_4_14
{
	public static void main(String[] args)
	{
		int N=100;
		Random random=new Random();
		int [] a=new int[N];
		for (int i = 0; i <N ; i++) 
		{
			a[i]=-1000+random.nextInt(2000);
		}
		Arrays.sort(a);
		System.out.println(count(a));
	}
	public static int count(int [] a)
	{
		int N=a.length;
		int cnt=0;
		for (int i = 0; i <N ; i++) 
		{
			for (int j = i+1; j <N ; j++) 
			{
				for (int k = j+1; k <N ; k++) 
				{
					if(BinarySearch.rank(-(a[i]+a[j]+a[k]), a)>k)
						cnt++;
				}
			}
		}
		return cnt;
	}
}
