package com.tongji.algorithms_1_3;

import javax.print.attribute.standard.RequestingUserName;
import javax.security.auth.x500.X500Principal;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

public class Exe_3_1_3 <Key extends Comparable<Key> ,Value>
{
	private int N;
	private Node first;
	
	private class Node
	{
		Key key;
		Value value;
		Node next;
		
		public Node(Key key,Value value,Node next)
		{
			this.key=key;
			this.value=value;
			this.next=next;
		}
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	public int size()
	{
		return N;
	}
	public void put(Key key,Value value)
	{
		if(isEmpty())
		{
			first=new Node(key, value, first);
			N++;
			return;
		}
		if(size()==1)
		{
			if(first.key.compareTo(key)<0)
			{
				first.next=new Node(key, value, null);
				N++;
			}
			else if(first.key.compareTo(key)>0)
			{
				first=new Node(key, value, first);
				N++;
			}
			else
				first.value=value;
			return;
		}
		//size()ÆðÂëÊÇ2
		if(first.key.compareTo(key)>0)
		{
			first=new Node(key, value, first);
			N++;
			return;
		}
		//Ò»¶¨´óÓÚfirst.key
		for(Node x=first;x!=null;x=x.next)
		{
			if(x.key.compareTo(key)==0)
			{
				Node node=new Node(key, value, x.next);
				x.next=node;
				return;
			}
			if(x.next.key.compareTo(key)>0)
			{
				Node node=new Node(key, value, x.next);
				x.next=node;
				N++;
				return;
			}
		}
	}
	public Value get(Key key)
	{
		for (Node x = first;  x!=null ; x=x.next) 
		{
			if(x.key.equals(key))
				return x.value;
		}
		return null;
	}
	public Iterable<Key> keys()
	{
		Queue<Key> queue=new Queue<>();
		for (Node x = first;  x!=null ; x=x.next) 
		{
			queue.enqueue(x.key);
		}
		return queue;
	}
	public static void main(String[] args)
	{
		Exe_3_1_3<String,Integer> e=new Exe_3_1_3<>();
		String [] strings="A B C D E F G H I G".split(" ");
		StdRandom.shuffle(strings);
		for (int i = 0; i <strings.length ; i++) 
		{
			e.put(strings[i], i);
		}
		for(String s:e.keys())
			System.out.println(s+" "+e.get(s));
			
	}
}
