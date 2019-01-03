package com.tongji.test_1_4;

public class Exe_1_4_20
{
	public static void main(String[] args)
	{
		int [] a= {1,2,3,4,10,9,8,7};
		int key=10;
		//双调嘛,主要是找到转折点,且转折点必然只有一个,用Exe_1_4_18的知识,但是注意是找局部最大了
		int i=find(a);
		//在左边查找
		int left=rankLeft(key, a, 0, i);
		//在右边查找
		int right=rankRight(key, a, i+1, a.length-1);
		if(left==-1 && right==-1)//左右都没有这个元素
			System.out.println("not contain");
		else
			System.out.println("contain");
	}
	public static int find(int [] a)
	{
		return find(a,0,a.length-1);
	}
	public static int find(int [] a,int lo,int hi)
	{
		int mid=lo+(hi-lo)/2;
		if(a[mid]>a[mid-1]&&a[mid]>a[mid+1])
			return mid;
		//在较大(改)的相邻元素的半边中继续查找 (不是很懂为什么)
		if(a[mid-1]>a[mid+1])
			return find(a,lo,mid-1);
		else 
			return find(a,mid+1,hi);
	}
	public static int rankLeft(int key,int [] a,int lo,int hi)
	{
		//左边数组是递增的
		if(hi<lo)
			return -1;
		int mid=lo+(hi-lo)/2;
		if(a[mid]<key)
			return rankLeft(key, a, mid+1, hi);
		else if(a[mid]>key)
			return rankLeft(key, a, lo, mid-1);
		else
			return mid;
	}
	public static int rankRight(int key,int [] a,int lo,int hi)
	{
		//右边数组是递减的
				if(hi<lo)
					return -1;
				int mid=lo+(hi-lo)/2;
				if(a[mid]<key)
					return rankLeft(key, a, lo, mid-1);
				else if(a[mid]>key)
					return rankLeft(key, a, mid+1, hi);
				else
					return mid;
	}
}
