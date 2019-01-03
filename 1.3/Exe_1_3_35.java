package com.tongji.test_1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import edu.princeton.cs.algs4.StdRandom;

public class Exe_1_3_35<Item> implements Iterable<Item>
{
	private int N;
	private Item[] a = (Item[]) new Object[1];

	public boolean isEmpty()
	{
		return N == 0;
	}

	public int size()
	{
		return N;
	}

	public void resize(int max)
	{
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
		{
			temp[i] = a[i];
		}
		a = temp;
	}

	public void enqueue(Item item)
	{
		if (N == a.length)
			resize(a.length * 2);
		a[N++] = item;
	}

	public Item dequeue()
	{
		Random random = new Random();
		int n = random.nextInt(N);
		Item temp = a[n];
		a[n] = a[--N];
		if (N == a.length / 4)
			resize(a.length / 2);
		return temp;
	}

	public static void main(String[] args)
	{
		Exe_1_3_35<Integer> e = new Exe_1_3_35<>();
		for (int i = 1; i < 14; i++)
		{
			e.enqueue(i);
		}
		for (Integer i : e)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		int N = e.size();//如果不这样下面输出会少,因为e.size()不断改变
		for (int i = 0; i < N; i++)
		{
			System.out.print(e.dequeue() + " ");
		}
	}

	public Iterator<Item> iterator()
	{
		return new RandomIterator();
	}

	private class RandomIterator implements Iterator<Item>
	{
		Item[] temp;
		private int i = 0;

		public RandomIterator()
		{
			temp = (Item[]) new Object[N];
			for (int i = 0; i < N; i++)
			{
				temp[i] = a[i];
			}
			StdRandom.shuffle(temp);
		}

		public boolean hasNext()
		{
			return i != N;
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}

		public Item next()
		{
			if (i == N)
				throw new NoSuchElementException();
			return temp[i++];
		}

	}
//	private class RandomIterator implements Iterator<Item>
//	{
//		private int i=N;
//		public boolean hasNext()
//		{
//			return i!=0;
//		}
//		public Item next()
//		{
//			if(i==0)
//				throw new NoSuchElementException();
//			int n=new Random().nextInt(i);
//			Item temp=a[n];
//			a[n]=a[--i];
//			return temp;
//		}
//		public void remove()
//		{
//			throw new UnsupportedOperationException();
//		}
//	}
}
