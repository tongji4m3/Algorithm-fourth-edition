package com.tongji.test_1_3;

import java.awt.event.ItemEvent;
import java.util.Iterator;

public class Exe_1_3_33_Deque<Item> implements Iterable<Item>
{
	private Node first;
	private Node last;
	private int N;
	
	private class Node
	{
		Item item;
		Node prev;
		Node next;
	}
	
	public Exe_1_3_33_Deque()
	{
		first=null;
		last=null;
		N=0;
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
		Node node=new Node();
		node.item=item;
		if(isEmpty())
		{
			first=node;
			last=node;
			node.prev=null;
			node.next=null;
		}
		else
		{
			node.prev=null;
			node.next=first;
			first.prev=node;
			first=node;
		}
		N++;
	}
	public void pushRight(Item item)
	{
		Node node=new Node();
		node.item=item;
		if(isEmpty())
		{
			first=node;
			last=node;
			node.prev=null;
			node.next=null;
		}
		else
		{
			node.next=null;
			node.prev=last;
			last.next=node;
			last=node;
		}
		N++;
	}
	public Item popLeft()
	{
		if(isEmpty())
			throw new RuntimeException();
		N--;
		Item item=first.item;
		if(first==last)
		{
			first=null;
			last=null;
		}
		else
		{
			first=first.next;
			first.prev.next=null;
			first.prev=null;
		}
		return item;
	}
	public Item popRight()
	{
		if(isEmpty())
			throw new RuntimeException();
		N--;
		Item item=last.item;
		if(first==last)
		{
			first=null;
			last=null;
		}
		else
		{
			last=last.prev;
			last.next.prev=null;
			last.next=null;
		}
		return item;
	}
	public Iterator<Item> iterator()
	{
		return new Iterator<Item>()
		{
			Node current=first;
			public boolean hasNext()
			{
				return current!=null;
			}
			public void remove()
			{
				throw new UnsupportedOperationException();
			}
			public Item next()
			{
				Item item=current.item;
				current=current.next;
				return item;
			}
		};
	}
	public static void main(String[] args)
	{
		Exe_1_3_33_Deque<Integer> deque=new Exe_1_3_33_Deque<>();
		for (int i = 0; i <5 ; i++) 
		{
			deque.pushLeft(i);
		}
		deque.pushRight(6);
		deque.pushRight(7);
		deque.popLeft();
		deque.popRight();
		for(Integer i:deque)
		{
			System.out.println(i);

		}
	}
}











