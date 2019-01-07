package com.tongji.algorithms_2_1;

import java.util.NoSuchElementException;

public class Exe_2_5_24<Key extends Comparable<Key>>
{
	private Key [] pq;
	private long [] time;
	private int N=0;
	private long timestamp=1;
	public Exe_2_5_24()
	{
		this(1);
	}
	public Exe_2_5_24(int initCapacity)
	{
		pq=(Key [])new Comparable[initCapacity+1];
		time=new long[initCapacity+1];
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	public int size()
	{
		return N;
	}
	public Key min()
	{
		if(isEmpty())
			throw new RuntimeException();
		return pq[1];
	}
	private void resize(int capacity)
	{
		assert capacity>N;
		Key [] temp=(Key[])new Comparable[capacity];
		long [] tempTime=new long[capacity];
		for (int i = 1; i <=N ; i++) 
		{
			temp[i]=pq[i];
			tempTime[i]=time[i];
		}
		pq=temp;
		time=tempTime;
	}
	public void insert(Key x)
	{
		if(N==pq.length-1)
			resize(2*pq.length);
		N++;
		pq[N]=x;
		time[N]=++timestamp;
		swim(N);
		assert isMinHeap();
	}
	public Key delMin()
	{
		if(N==0)
			throw new NoSuchElementException();
		exch(1, N);
		Key min=pq[N--];
		sink(1);
		pq[N+1]=null;
		time[N+1]=0;
		if(N>0 && N==(pq.length-1)/4)
			resize(pq.length/2);
		assert isMinHeap();
		return min;
	}
	private void swim(int k)
	{
		while(k>1 && greater(k/2, k))
		{
			exch(k, k/2);
			k=k/2;
		}
	}
	private void sink(int k)
	{
		while(2*k<=N)
		{
			int j=2*k;
			while(j<N && greater(j, j+1))
				j++;
			if(!greater(k, j))
				break;
			exch(k, j);
			k=j;
		}
	}
	//比较时,如果两者是相等的,则看谁是先插入进来的,值大的为后插入的,排后面
	private boolean greater(int i,int j)
	{
		int cmp=pq[i].compareTo(pq[j]);
		if(cmp>0)
			return true;
		if(cmp<0)
			return false;
		return time[i]>time[j];//重点在这里
	}
	private void exch(int i,int j)
	{
		Key temp=pq[i];
		pq[i]=pq[j];
		pq[j]=temp;
		long tempTime=time[i];
		time[i]=time[j];
		time[j]=tempTime;
	}
	private boolean isMinHeap()
	{
		return isMinHeap(1);
	}
	private boolean isMinHeap(int k)
	{
		if(k>N)
			return true;
		int left=2*k;
		int right=2*k+1;
		if(left<=N && greater(k, left))
			return false;
		if(right<=N && greater(k, right))
			return false;
		return isMinHeap(left) && isMinHeap(right);
	}
	//记录稳定性
	private static final class Tuple implements Comparable<Tuple>
	{
		private String name;
		private int id;
		
		private Tuple(String name,int id)
		{
			this.name=name;
			this.id=id;
		}
		public int compareTo(Tuple that)
		{
			return this.name.compareTo(that.name);
		}
		public String toString()
		{
			return name +" "+id;
		}
	}
	public static void main(String[] args)
	{
		Exe_2_5_24<Tuple> pq=new Exe_2_5_24<>();
		
		String text = "it was the best of times it was the worst of times it was the "
                + "age of wisdom it was the age of foolishness it was the epoch "
                + "belief it was the epoch of incredulity it was the season of light "
                + "it was the season of darkness it was the spring of hope it was the "
                + "winter of despair";
		String [] strings=text.split(" ");
		for (int i = 0; i <strings.length ; i++) 
		{
			pq.insert(new Tuple(strings[i], i));
		}
		while(!pq.isEmpty())
			System.out.println(pq.delMin());
		System.out.println();
	}
}






