package com.tongji.algorithms_1_5;

import java.util.NoSuchElementException;
import java.util.Random;

import edu.princeton.cs.algs4.Stack;

//这题废了,没有解决,先留着,之后再看看`
public class Exe_2_4_29
{
	private int N;
	private Node [] delMin;
	private Node [] delMax;
	private static int count=0;//为了每个key对应一个索引,在Node中使用的
	
	//构建一个结点类，里面存放有当前结点的值、对应数组下标
	//为了删除时,两个堆都能兼顾
	private class Node
	{
		public Integer key;
		public int i;
		public Node(Integer key,int count)
		{
			this.key=key;
			i=count;
		}
	}
	public Exe_2_4_29(int capacity)
	{
		delMax=new Node[capacity+1];
		delMin=new Node[capacity+1];
	}
	public int size()
	{
		return N;
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	public void insert(Integer key)
	{
		delMax[++N]=new Node(key, ++count);
		swimMax(N);
		swimMin(N);
	}
	public Integer deleteMax()
	{
		Integer key=delMax[1].key;
		int i=delMax[1].i;
		exch(delMax, 1, N);
		delMax[N]=null;
		remove(delMin,i);
		N--;
		sinkMax(1);
		sinkMin(1);
		return key;
	}
	public void sinkMax(int k)
	{
		while(2*k<=N)
		{
			int j=2*k;
			if(j<N && less(delMax, j, j+1))
				j++;
			if(!less(delMax, k, j))
				break;
			exch(delMax, k, j);
			k=j;
		}
	}
	public void sinkMin(int k)
	{
		while(2*k<=N)
		{
			int j=2*k;
			if(j<N && less(delMin, j+1, j))
				j++;
			if(!less(delMin, j, k))
				break;
			exch(delMin, k, j);
			k=j;
		}
	}
	public void remove(Node [] a,int k)
	{
		for (int i = N; i >=1 ; i--) 
		{
			if(k==a[i].i)
			{
				exch(a, i, N);
				a[N]=null;
				break;
			}
		}
	}
	public Integer findMax()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		return delMax[1].key;
	}
	public Integer findMin()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		return delMin[1].key;
	}
	private void swimMax(int k)
	{
		while(k>1 && less(delMax, k/2, k))
		{
			exch(delMax,k,k/2);
			k=k/2;
		}
	}
	private void swimMin(int k)//使得最小的在最上面,为delMin数组准备的
	{
		while(k>1 && less(delMin, k, k/2))
		{
			exch(delMin,k,k/2);
			k=k/2;
		}
	}
	private boolean less(Node [] a,int i,int j)
	{
		return  Integer.compare(a[i].key, a[j].key)<0;
	}
	private void exch(Node [] a,int i,int j)
	{
		Node temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void main(String[] args)
	{
		int N=20;
		int M=5;
		Exe_2_4_29 pq=new Exe_2_4_29(M+1);
		Random random=new Random();
		for (int i = 0; i < N; i++) 
		{
			pq.insert(random.nextInt(20));
			if(pq.size()>M)
				pq.deleteMax();
		}
		Stack<Integer> stack=new Stack<>();
		while(!pq.isEmpty())
			stack.push(pq.deleteMax());
		for(Integer e:stack)
			System.out.println(e);
	}
}
