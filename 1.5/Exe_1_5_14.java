package com.tongji.algorithms_1_5;

public class Exe_1_5_14
{
	private int [] id;
	private int [] height;
	private int  count;
	
	public Exe_1_5_14(int N)
	{
		count=N;
		id=new int[N];
		height=new int[N];
		for (int i = 0; i <i ; i++) 
		{
			id[i]=i;
			height[i]=1;
		}
	}
	public int count()
	{
		return count;
	}
	public boolean connected(int p,int q)
	{
		return find(p)==find(q);
	}
	public int find(int p)
	{
		while(p!=id[p])
		{
			p=id[p];
		}
		return p;
	}
	public void union(int p,int q)
	{
		int i=find(p);
		int j=find(q);
		if(i==j)
			return;
		if(height[i]<height[j])
		{
			id[i]=j;
		}
		else if(height[i]>height[j])
		{
			id[j]=i;
		}
		else
		{
			id[j]=i;
			height[i]++;
			//只有树一样高时高度才增加
		}
		count--;
	}
}


