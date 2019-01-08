package com.tongji.algorithms_1_3;

import edu.princeton.cs.algs4.Queue;

public class Exe_3_1_2<Key,Value>
{
	private Key [] keys;
	private Value [] values;
	private int N;
	private static final int INIT_SIZE=8;
	
	public Exe_3_1_2(int capacity)
	{
		keys=(Key [])new Object[capacity];
		values=(Value [])new Object[capacity];
	}
	public Exe_3_1_2()
	{
		keys=(Key [])new Object[INIT_SIZE];
		values=(Value [])new Object[INIT_SIZE];
	}
	public int size()
	{
		return N;
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	public void resize(int capacity)
	{
		Key [] tempk=(Key[])new Object[capacity];
		Value [] tempv=(Value [])new Object[capacity];
		for (int i = 0; i <N ; i++) 
		{
			tempk[i]=keys[i];
			tempv[i]=values[i];
		}
		keys=tempk;
		values=tempv;
	}
	public void put(Key key,Value value)
	{
		delete(key);
		if(N>=values.length)
			resize(2*values.length);
		
		keys[N]=key;
		values[N]=value;
		N++;
	}
	public Value get(Key key)
	{
		for (int i = 0; i <N ; i++) 
		{
			if(key.equals(keys[i]))
				return values[i];
		}
		throw null;
	}
	public Iterable<Key>keys()
	{
		Queue<Key>queue=new Queue<>();
		for (int i = 0; i <N ; i++) 
		{
			queue.enqueue(keys[i]);
		}
		return queue;
	}
	public void delete(Key key)
	{
		for (int i = 0; i <N ; i++) 
		{
			if(key.equals(keys[i]))
			{
				keys[i]=keys[N-1];
				values[i]=values[N-1];
				keys[N-1]=null;
				values[N-1]=null;
				N--;
				if(N>0 && N==keys.length/4)
					resize(keys.length/2);
				return;
			}
		}
	}
}

