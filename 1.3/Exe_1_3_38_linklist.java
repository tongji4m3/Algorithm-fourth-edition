package com.tongji.test_1_3;

import java.util.NoSuchElementException;

public class Exe_1_3_38_linklist<Item>
{
	private class Node 
	{
		Item item;
		Node next;
	}
	private Node first;
	private Node last;
	private int N;
	public boolean isEmpty()
	{
		return N==0;
	}
	public int size()
	{
		return N;
	}
	public void insert(Item item)
	{
		
		Node oldlast=last;
		last=new Node();
		last.item=item;
		last.next=null;
		if(isEmpty())
			first=last;
		else
			oldlast.next=last;
		N++;
	}
	public Item delete(int k)
	{
		if(k>N || k<=0)
			throw new NoSuchElementException();
		if(isEmpty())
			throw new RuntimeException();
		if(k==1)
		{
			Item item=first.item;
			first=first.next;
			N--;
			if(isEmpty())
				last=null;
			return item;
		}
		Node current=first;
		int i;
		for (i = 0; i <k-2 && current!=null; i++) 
		{
			current=current.next;
		}
		if(current==null || i!=k-3 || current.next==null)
		{
		}
		Item item=current.next.item;
		current.next=current.next.next;
		return item;
		
	}
	public void print()
	{
		for (Node x = first;  x!=null ; x=x.next) 
		{
			System.out.print(x.item+" ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		Exe_1_3_38_linklist<Integer> e=new Exe_1_3_38_linklist<>();
		for (int i = 0; i <10 ; i++) 
		{
			e.insert(i);
		}
		System.out.println(e.delete(5));
		e.print();
	}
}