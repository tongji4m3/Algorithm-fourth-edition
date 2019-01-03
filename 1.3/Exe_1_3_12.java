package com.tongji.test_1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.tongji.algorithms_1_3.Stack;

public class Exe_1_3_12<Item> implements Iterable<Item>
{
	private int N;
	private Item [] a;
	
	public Exe_1_3_12()
	{
		a=(Item [])new Object[1];
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	public int size()
	{
		return N;
	}
	public void push(Item item)
	{
		if(N==a.length)
			resize(2*a.length);
		a[N++]=item;
	}
	private void resize(int max)
	{
		Item [] temp=(Item [])new Object[max];
		for(int i=0;i<N;i++)
		{
			temp[i]=a[i];
		}
		a=temp;
	}
	public Item pop()
	{
		Item item=a[--N];
		a[N]=null;
		if(N>0 && N==a.length/4)
			resize(a.length/2);
		return item;
	}
	public Item peek()
	{
		return a[N-1];
	}
	public static Stack<String> copy(Stack<String> stack)
	{
		Stack<String> stack1=new Stack<>();
		Stack<String> stack2=new Stack<>();
		//要倒两次顺序才是对的
		for(String s:stack)
		{
			stack1.push(s);
		}
		for(String s:stack1)
		{
			stack2.push(s);
		}
		return stack2;
	}
	public Iterator<Item> iterator()
	{
		return new Iterator<Item>()
		{
			int i=N;
			public boolean hasNext()
			{
				return i>0;
			}
			public Item next()
			{
				if(i==0)
					throw new NoSuchElementException();
				return a[--i];
			}
			public void remove()
			{
				throw new UnsupportedOperationException();
			}
		};
	}
}







