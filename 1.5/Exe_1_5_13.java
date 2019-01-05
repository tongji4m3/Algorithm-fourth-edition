package com.tongji.algorithms_1_5;

public class Exe_1_5_13
{
	private int [] id;
	private int [] sz;
	private int count;
	
	public Exe_1_5_13(int N)
	{
		count=N;
		id=new int[N];
		sz=new int[N];
		for (int i = 0; i <N ; i++) 
		{
			id[i]=i;
			sz[i]=1;
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
		int root=p;
		while(root!=id[root])
		{
			root=id[root];
		}
		while(p!=root)
		{
			int temp=id[p];
			id[p]=root;
			p=temp;
		}
		return root;
	}
	public void union(int p,int q)
	{
		int i=find(p);
		int j=find(q);
		if(i==j)
			return;
		if(sz[i]<sz[j])
		{
			id[i]=j;
			id[j]+=id[i];
		}
		else
		{
			id[j]=i;
			sz[i]+=sz[j];
		}
		count--;
	}
}


