package com.tongji.test_1_3;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class Exe_1_3_40
{
	private Node first;
	private int N;
	private class Node
	{
		Character ch;
		Node next;
	}
	public void push(Character ch)
	{
		N++;
		Node oldfirst=first;
		first=new Node();
		first.ch=ch;
		first.next=oldfirst;
	}
	public boolean isRepeat(char ch)
	{
		for (Node x = first;  x!=null ; x=x.next) 
		{
			if(x.ch==ch)
				return true;
		}
		return false;
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	public int size()
	{
		return N;
	}
	public void delete(char ch)
	{
		int k=0;
		for (Node x = first;  x!=null ; x=x.next) 
		{
			k++;
			if(x.ch==ch)
				break;
		}
		//´Ó1ËãÆð
		if(isEmpty() || k<=0 || k>N)
			throw new RuntimeException();
		N--;
		if(k==1)
		{
			first=first.next;
			return;
		}
		Node current=first;
		int i;
		for ( i = 0; i < k-2 && current!=null ; i++) 
		{
			current=current.next;
		}
		if(current!=null && current.next!=null && i==k-2 )
		{
			current.next=current.next.next;
		}
	}
	public void print()
	{
		for(Node x=first;x!=null;x=x.next)
			System.out.print(x.ch+" ");
	}
	public static void main(String[] args)
	{
		char [] chars= {'a','b','c','d','e','a','e'};
		Exe_1_3_40 link=new Exe_1_3_40();
		for (int i = 0; i <chars.length ; i++) 
		{
			if(link.isEmpty())
				link.push(chars[i]);
			else
			{
				if(link.isRepeat(chars[i]))
				{
					link.delete(chars[i]);
					link.push(chars[i]);
				}
				else
					link.push(chars[i]);
			}
		}
		link.print();
	}
}
