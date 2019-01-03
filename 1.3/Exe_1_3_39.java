package com.tongji.test_1_3;

public class Exe_1_3_39<Item>
{
	private int N;
	private int head;
	private int tail;
	private Item [] a;
	
	public Exe_1_3_39()
	{
		a=(Item [])new Object[10];
	}
	public Exe_1_3_39(int capacity)
	{
		a=(Item [])new Object[capacity];
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	public int size()
	{
		return N;
	}
	public void enqueue(Item item)
	{
		if(N==a.length)
			throw new RuntimeException();
		N++;
		a[tail++]=item;
		if(tail==a.length)
			tail=0;
	}
	public Item dequeue()
	{
		if(isEmpty())
			throw new RuntimeException();
		N--;
		Item item=a[head++];
		if(head==a.length)
			head=0;
		return item;
	}
}




