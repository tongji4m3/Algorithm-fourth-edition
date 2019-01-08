package com.tongji.algorithms_1_3;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

public class Exe_3_1_12<Key extends Comparable<Key>,Value>
{
	private final static int INIT_CAPACITY=2;
	private Item [] items;
	private int N;
	
	private class Item implements Comparable<Item>
	{
		Key key;
		Value value;
		public Item(Key key,Value value)
		{
			this.key=key;
			this.value=value;
		}
		public int compareTo(Item that)
		{
			return this.key.compareTo(that.key);
		}
	}
	public Exe_3_1_12()
	{
		this(INIT_CAPACITY);
	}
	public Exe_3_1_12(Item [] init)
	{
		for (int i = 0; i <init.length ; i++) 
		{
			items[i]=init[i];
		}
		Merge.sort(items);
	}
	public Exe_3_1_12(int capacity)
	{
		items=(Item [])new Object[capacity];
	}
	
	public int size()
	{
		return N;
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	private void resize(int capcity)
	{
		assert capcity>=N;
		Item [] temp=(Item [])new Object[capcity];
		for (int i = 0; i <size() ; i++) 
		{
			temp[i]=items[i];
		}
		items=temp;
	}
	public boolean contains(Key key)
	{
		if(key==null)
			throw new RuntimeException();
		return get(key)!=null;
	}
	public int rank(Key key)
	{
		if(key==null)
			throw new RuntimeException();
		int lo=0;
		int hi=N-1;
		while(lo<=hi)
		{
			int mid=lo+(hi-lo)/2;
			int cmp=key.compareTo(items[mid].key);
			if(cmp<0)
				hi=mid-1;
			else if(cmp>0)
				lo=mid+1;
			else 
				return mid;
		}
		return lo;
	}
	public Value get(Key key)
	{
		if(key==null)
			throw new RuntimeException();
		if(isEmpty())
			return null;
		int i=rank(key);
		if(i<N && key.compareTo(items[i].key)==0)
			return items[i].value;
		return null;
	}
	public void delete(Key key)
	{
		if(key==null)
			throw new RuntimeException();
		if(isEmpty())
			throw new NoSuchElementException();
		int i=rank(key);
		if(i>=N || key.compareTo(items[i].key)!=0)
			return ;
		for (int j = i; j < N-1 ; j++) 
		{
			items[j].key=items[j+1].key;
			items[j].value=items[j+1].value;
		}
		N--;
		items[N]=null;
		if(N>0 && N==items.length/4) 
		{
			resize(items.length/2);
		}
		assert check();
	}
	public void put(Key key,Value value)
	{
		if(key==null)
			throw new RuntimeException();
		if(value==null)
		{
			delete(key);
			return;
		}
		int i=rank(key);
		if(i<N && key.compareTo(items[i].key)==0)
		{
			items[i].value=value;
			return;
		}
		if(N==items.length)
			resize(2*items.length);
		for (int j = N; j >i ; j--) 
		{
			items[j].key=items[j-1].key;
			items[j].value=items[j-1].value;
		}
		items[i].key=key;
		items[i].value=value;
		N++;
		assert check();
	}
	private boolean isSorted()
	{
		for (int i = 1; i < N; i++) 
		{
			if(items[i].key.compareTo(items[i-1].key)<0)
				return false;
		}
		return true;
	}
	public Key min()
	{
		if(isEmpty())
			throw new RuntimeException();
		return items[0].key;
	}
	public Key max()
	{
		if(isEmpty())
			throw new RuntimeException();
		return items[N-1].key;
	}
	public Iterable<Key> keys()
	{
		return keys(min(), max());
	}
	public Iterable<Key> keys(Key lo,Key hi)
	{
		if(lo==null)
			throw new RuntimeException();
		if(hi==null)
			throw new RuntimeException();
		Queue<Key> queue=new Queue<>();
		if(lo.compareTo(hi)>0)
			return queue;
		for (int i = rank(lo); i <rank(hi) ; i++) 
		{
			queue.enqueue(items[i].key);
		}
		if(contains(hi))
			queue.enqueue(hi);
		return queue;
	}
	public Key select(int k)
	{
		if(k<0 || k>=N )
			return null;
		return items[k].key;
	}
	public void delMax()
	{
		if(isEmpty())
			throw new RuntimeException();
		delete(max());
	}
	public void delMin()
	{
		if(isEmpty())
			throw new RuntimeException();
		delete(min());
	}
	public Key ceiling(Key key)
	{
		if(key==null)
			throw new RuntimeException();
		int i=rank(key);
		if(i<N && key.compareTo(items[i].key)==0)
			return items[i].key;
		return null;
	}
	public Key floor(Key key)
	{
		if(key==null)
			throw new RuntimeException();
		int i=rank(key);
		if(i<N && key.compareTo(items[i].key)==0)
			return items[i].key;
		if(i>0)
			return items[i-1].key;
		return null;
	}
	
	public int size(Key lo,Key hi)
	{
		if(lo==null || hi==null)
			throw new RuntimeException();
		if(lo.compareTo(hi)<0)
			return 0;
		if(contains(hi))
			return rank(hi)-rank(lo)+1;
		else
			return rank(hi)-rank(lo);
	}
	public boolean check()
	{
		return isSorted()&&rankCheck();
	}
	public boolean rankCheck()
	{
		for (int i = 0; i <size() ; i++) 
		{
			if(i!=rank(select(i)))
				return false;
		}
		for (int i = 0; i <size() ; i++) 
		{
			if(items[i].key.compareTo(select(rank(items[i].key)))!=0)
				return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		Exe_3_1_12<String, Integer> e=new Exe_3_1_12<>();
		for (int i = 0; !StdIn.isEmpty() ; i++) 
		{
			String key=StdIn.readString();
			e.put(key, i);
		}
		for(String s:e.keys())
		{
			System.out.println(s+" "+e.get(s));
		}

	}
}












