package com.tongji.test_1_3;

import java.util.NoSuchElementException;

public class Exe_1_3_38_Array<Item>
{
	private int N;
	private Item [] a=(Item [])new Object[1];
	public boolean isEmpty()
	{
		return N==0;
	}
	public void resize(int max)
	{
		Item [] temp=(Item [])new Object[max];
		for (int i = 0; i < N; i++) 
		{
			temp[i]=a[i];
		}
		a=temp;
	}
	public void insert(Item x)
	{
		if(N==a.length)
			resize(2*a.length);
		a[N++]=x;
	}
	public Item delete(int k)
	{
		if(k>N || k<0)
			throw new NoSuchElementException();
		Item item =a[k-1];
		for (int i = k; i <a.length ; i++) 
		{
			a[i-1]=a[i];
		}
		N--;
		if(N==a.length/4)
			resize(a.length/2);
		return item;
	}
}
