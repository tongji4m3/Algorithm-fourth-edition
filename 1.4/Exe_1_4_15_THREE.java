package com.tongji.test_1_4;

import java.util.Arrays;

public class Exe_1_4_15_THREE
{
	public static int count(int [] a)
	{
		int cnt=0;
		for (int i = 0; i <a.length ; i++) 
		{
			int lo=i+1;
			int hi=a.length-1;
			while(lo<hi)
			{
				if(a[i]+a[lo]+a[hi] <0)
					lo++;
				else if(a[i]+a[lo]+a[hi] >0)
					hi--;
				else
				{
					cnt++;
					lo++;
					hi--;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args)
	{
		int [] a= {-6,-5,-2,-1,0,0,1,2,3,4,5};
		Arrays.sort(a);
		System.out.println(count(a));

	}
}
