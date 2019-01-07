package com.tongji.algorithms_1_5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;

public class Exe_2_4_22 <Key> implements Iterable<Key>
{
	private Key [] pq;
	private int N;
	private Comparator<Key> comparator;
	private Key min;//Exe_2_4_27
	
	public Exe_2_4_22(int initCapacity)
	{
		pq=(Key [])new Object[initCapacity+1];
		N=0;
	}
	public Exe_2_4_22()
	{
		this(1);
	}
	public Exe_2_4_22(int initCapacity,Comparator<Key> comparator)
	{
		this.comparator=comparator;
		pq=(Key[])new Object[initCapacity+1];
		N=0;
	}
	public Exe_2_4_22(Comparator<Key> comparator)
	{
		this(1,comparator);
	}
	public Exe_2_4_22(Key [] keys)
	{
		N=keys.length;
		pq=(Key [])new Object[keys.length+1];
		// 复制元素的同时更新最小值。
        min = keys[0];
        for (int i = 0; i < N; i++)
        {
            pq[i + 1] = keys[i];
            if (( (Comparable<Key>) pq[i + 1]).compareTo(min) < 0)
                min = pq[i + 1];
        }
		for (int k = N/2; k >=1 ; k--) 
		{
			sink(k);
		}
		assert isMaxHeap();
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	public int size()
	{
		return N;
	}
	public Key max()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		return pq[1];
	}
	private void resize(int capacity)
	{
		assert capacity >N;
		Key [] temp=(Key [])new Object[capacity];
		for (int i = 1; i <=N ; i++) 
		{
			temp[i]=pq[i];
		}
		pq=temp;
	}
	public Key min()
	{
		return min;
	}
	public void insert(Key key)
	{
		if(N==pq.length-1)
			resize(2*pq.length);
		pq[++N]=key;
		
	    // 更新最小值。
        if (min == null)
            min = key;
        else if (((Comparable<Key>)key).compareTo(min) < 0)
            this.min = key;

		swim(N);
		assert isMaxHeap();
	}
	public Key delMax()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		Key max=pq[1];
		exch(1, N--);
		sink(1);
		pq[N+1]=null;
		if(N>0 && N==(pq.length-1)/4)
			resize(pq.length/2);
		// 如果堆变为空。
        if (isEmpty())
            min = null;

		assert isMaxHeap();
		return max;
	}
	private void swim(int k)
	{
		while(k>1 && less(k/2, k))
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
			if(j<N && less(j, j+1))
				j=j+1;
			if(!less(k, j))
				break;
			exch(k, j);
			k=j;
		}
	}
	private boolean less(int i,int j)
	{
		if(comparator==null)
			return ((Comparable<Key>) pq[i]).compareTo(pq[j])<0;
		else
			return comparator.compare(pq[i], pq[j])<0;
	}
	private void exch(int i,int j)
	{
		Key swap=pq[i];
		pq[i]=pq[j];
		pq[j]=swap;
	}
	private boolean isMaxHeap()
	{
		return isMaxHeap(1);
	}
	private boolean isMaxHeap(int k)
	{
		if(k>N)
			return true;
		int left=2*k;
		int right=2*k+1;
		if(left<=N && less(k, left))
			return false;
		if(right<=N && less(k, right))
			return false;
		return isMaxHeap(left) && isMaxHeap(right);
	}
	public Iterator<Key> iterator()
	{
		return new HeapIterator();
	}
	private class HeapIterator implements Iterator<Key>
	{
		private Exe_2_4_22<Key> copy;
		
		public HeapIterator ()
		{
			if(comparator == null)
				copy=new Exe_2_4_22<Key>(size());
			else
				copy=new Exe_2_4_22<Key>(size(),comparator);
			for (int i = 0; i <=N ; i++) 
			{
				copy.insert(pq[i]);
			}
		}
		public boolean hasNext()
		{
			return !copy.isEmpty();
		}
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		public Key next()
		{
			if(!hasNext())
				throw new NoSuchElementException();
			return copy.delMax();
		}
	}
	public static void main(String[] args)
	{
		Exe_2_4_22<String> pq=new Exe_2_4_22<>();
		while(!StdIn.isEmpty())
		{
			String item=StdIn.readString();
			if(!item.equals("-"))
				pq.insert(item);
			else if(!pq.isEmpty())
				System.out.print(pq.delMax()+" ");
		}
		System.out.println(pq.size());
	}
}


