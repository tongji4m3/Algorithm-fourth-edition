package com.tongji.algorithms_1_3;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

public class Exe_3_1_16<Key extends Comparable<Key>,Value>
{
	private static final int INIT_CAPACITY=2;
	private Key[] keys;
	private Value[] values;
	private int N=0;
	
	public Exe_3_1_16()
	{
		this(INIT_CAPACITY);
	}
	public Exe_3_1_16(int capacity)
	{
		keys=(Key[])new Comparable[capacity];
		values=(Value [])new Object[capacity];
	}
	private void resize(int capacity)
	{
		assert capacity>=N;
		Key [] tempk=(Key[])new Comparable[capacity];
		Value [] tempv=(Value [])new Object[capacity];
		for (int i = 0; i <N ; i++) 
		{
			tempk[i]=keys[i];
			tempv[i]=values[i];
		}
		values=tempv;
		keys=tempk;
	}
	public int size()
	{
		return N;
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	public boolean contains(Key key)
	{
		if(key==null)
			throw new RuntimeException();
		return get(key)!=null;
	}
	public Value get(Key key)
	{
		if(key==null)
			throw new RuntimeException();
		if(isEmpty())
			return null;
		int i=rank(key);
		if(i<N && keys[i].compareTo(key)==0)
			return values[i];
		return null;
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
			int cmp=key.compareTo(keys[mid]);
			if(cmp<0)
				hi=mid-1;
			else if(cmp>0)
				lo=mid+1;
			else
				return mid;
		}
		return lo;
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
		if(i<N && keys[i].compareTo(key)==0)
		{
			values[i]=value;
			return;
		}
		if(N==keys.length)
			resize(2*keys.length);
		for (int j = N; j > i ; j--) 
		{
			keys[j]=keys[j-1];
			values[j]=values[j-1];
		}
		keys[i]=key;
		values[i]=value;
		N++;
		assert check();
	}
	public void delete(Key key)
	{
		if(key==null)
			throw new RuntimeException();
		if(isEmpty())
			return;
		int i=rank(key);
		if(i==N || keys[i].compareTo(key)!=0)
			return;
		for (int j = i; j < N-1 ; j++) 
		{
			keys[j]=keys[j+1];
			values[j]=values[j+1];
		}
		N--;
		keys[N]=null;
		values[N]=null;
		if(N>0 && N==keys.length/4)
			resize(keys.length/2);
		assert check() ;
	}
	public void deleteMin()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		delete(min());
	}
	public void deleteMax() {
		if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
		delete(max());
	}
	public Key min()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		return keys[0];
	}
	public Key max() {
		if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
		return keys[N-1];
	}
	public Key select(int k)
	{
		if(k<0 || k>=size())
		{
			throw new NoSuchElementException();
		}
		return keys[k];
	}
	public Key floor(Key key)
	{
		if(key==null)
			throw new RuntimeException();
		int i=rank(key);
		if(i<N && key.compareTo(keys[i])==0)
			return keys[i];
		if(i==0)
			return null;
		else
			return keys[i-1];
	}
	public Key ceiling(Key key)
	{
		if(key==null)
			throw new RuntimeException();
		int i=rank(key);
		if(i==N)
			return null;
		else 
			return keys[i];
	}
	public int size(Key lo,Key hi)
	{
		if (lo == null) throw new IllegalArgumentException("first argument to size() is null"); 
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null"); 
        
        if(lo.compareTo(hi)>0)
        	return 0;
		if(contains(hi))
			return rank(hi)-rank(lo)+1;
		else
			return rank(hi)-rank(lo);
	}
	public Iterable<Key> keys()
	{
		return keys(min(),max());
	}
	public Iterable<Key> keys(Key lo,Key hi)
	{
		if (lo == null) throw new IllegalArgumentException("first argument to keys() is null"); 
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null"); 
        Queue<Key> queue=new Queue<>();
        if(lo.compareTo(hi)>0)
        	return queue;
        for (int i = rank(lo); i < rank(hi); i++) 
		{
			queue.enqueue(keys[i]);
		}
        if(contains(hi))
        	queue.enqueue(keys[rank(hi)]);
        return queue;
	}
	private boolean check()
	{
		return isSorted()&&rankCheck();
	}
	private boolean isSorted()
	{
		for (int i = 1; i <size() ; i++) 
		{
			if(keys[i].compareTo(keys[i-1])<0)
				return false;
		}
		return true;
	}
	private boolean rankCheck()
	{
		for (int i = 0; i <size() ; i++) 
		{
			if(i!=rank(select(i)))
				return false;
		}
		for (int i = 0; i <size() ; i++) 
		{
			if(keys[i].compareTo(select(rank(keys[i])))!=0)
				return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		Exe_3_1_16<String, Integer> e=new Exe_3_1_16<>();
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
