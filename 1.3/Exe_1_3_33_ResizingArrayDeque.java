package com.tongji.test_1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Exe_1_3_33_ResizingArrayDeque<Item> implements Iterable<Item>
{
	private int N;
	private Item [] deque;
	private int head;
	private int tail;
	
	public Exe_1_3_33_ResizingArrayDeque()
	{
		//为了向左右都可以插入
		deque=(Item [])new Object[3];
		head=1;
		tail=1;
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	public int size()
	{
		return N;
	}
	public void pushLeft(Item item)
	{
		if(head==0)
			resize(3*size());
		deque[--head]=item;
		N++;
	}
	public void pushRight(Item item)
	{
		if(tail==deque.length)
			resize(3*size());
		deque[tail++]=item;
		N--;
	}
	public Item popLeft()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		if(size()*6<deque.length)
			resize(size()*3);
		return deque[head++];
	}
	public Item popRight()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		if(size()*6<deque.length)
			resize(size()*3);
		return deque[--tail];
	}
	public void resize(int size)
	{
		if(size<3)
			size=3;
		Item [] temp=(Item [])new Object[size];
		int j=size/3;
		for (int i = head; i <tail ; i++) 
		{
			temp[j++]=deque[i];
		}
		deque=temp;
		head=size/3;
		tail=j;
	}
	public Iterator<Item> iterator()
	{
		return new Iterator<Item>()
		{
			private int current=head;
			public boolean hasNext()
			{
				return current!=tail;
			}
			public void remove()
			{
				throw new UnsupportedOperationException();
			}
			public Item next()
			{
				return deque[current++];
				
			}
		};
}
	
