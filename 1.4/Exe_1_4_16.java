package com.tongji.test_1_4;

import java.util.Arrays;
import java.util.Random;

public class Exe_1_4_16
{
	public static void main(String[] args)
	{
		int N=10;
		double [] a=new double[N];
		Random random=new Random();
		for (int i = 0; i <N ; i++) 
		{
			a[i]=random.nextDouble();
		}
		Arrays.sort(a);
		double min=Math.abs(a[0]-a[1]);
		for (int i = 1; i <N ; i++) 
		{
			double temp=Math.abs(a[i]-a[i-1]);
			if(min>temp)
				min=temp;
		}
		System.out.printf("min:%.2f\n",min);

	}
}
