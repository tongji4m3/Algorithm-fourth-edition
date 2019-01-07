package com.tongji.algorithms_1_5;

public class Exe_2_4_3_orderArray<Key extends Comparable<Key>>
{
	private Key [] pq;
	private int N;
	
	public Exe_2_4_3_orderArray(int capacity)
	{
		pq=(Key [])new Comparable[capacity];
		N=0;
	}
	
	public boolean isEmpty()
	{
		return N==0;
	}
	public int size()
	{
		return N;
	}
	public Key delMax()
	{
		return pq[--N];
	}
	public void insert(Key key)
	{
		int i=N-1;
		while(i>=0 && less(key,pq[i]))
		{
			pq[i+1]=pq[i];
			i--;
		}
		pq[i+1]=key;
		N++;
	}
	private boolean less(Key v,Key w)
	{
		return v.compareTo(w)<0;
	}
}




