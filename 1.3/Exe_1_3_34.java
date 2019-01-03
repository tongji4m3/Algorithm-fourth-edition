package com.tongji.test_1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class Exe_1_3_34<Item> implements Iterable<Item>
{
	private Item [] a;
	private int N;
	
	public Exe_1_3_34()
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
	public void add(Item item)
	{
		if(N==a.length)
			resize(2*a.length);
		a[N++]=item;
	}
	private void resize(int max)
	{
		assert max>N;
		Item [] temp=(Item [])new Object[max];
		for (int i = 0; i <N ; i++) 
		{
			temp[i]=a[i];
		}
		a=temp;
	}
	public Iterator<Item> iterator()
	{
		return new RandomIterator();
	}
	private class RandomIterator implements Iterator<Item>
	{
		Item [] temp;
		private int i=0;
		public RandomIterator()
		{
			temp=(Item [])new Object[N];
			for (int i = 0; i <N ; i++) 
			{
				temp[i]=a[i];
			}
			StdRandom.shuffle(temp);
		}
		public boolean hasNext()
		{
			return i!=N;
		}
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		public Item next()
		{
			if(i==N)
				throw new NoSuchElementException();
			return temp[i++];
		}
		
	}
	public static void main(String[] args)
	{
		Exe_1_3_34<Integer> test=new Exe_1_3_34<>();
		for (int i = 0; i <10 ; i++) 
		{
			test.add(i);
		}
		for(Integer i:test)
		{
			System.out.println(i+" ");
		}
	}
}















