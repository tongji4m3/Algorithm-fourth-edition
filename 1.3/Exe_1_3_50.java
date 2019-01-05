package com.tongji.test_1_3;

public class Exe_1_3_50<Item> implement Iterable<Item>
{
	private Node first;
	private int N;
	private int operates;
	
	private class Node
	{
		Item item;
		Node next;
	}
	
	public boolean isEmpty()
	{
		return N==0;
	}
	public int size()
	{
		return N;
	}
	public void push(Item item)
	{
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		N++;
		operates++;
	}
	public Item pop()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		Item item=first.item;
		first=first.next;
		N--;
		operates++;
		return item;
	}
	public Iterator<Item> iterator()
	{
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>
	{
		private Node current=first;
		private int count=operates;
		public boolean hasNext()
		{
			//如果在迭代的时候使用了push()或者pop()操作,那么operates++,就会抛出异常
			if(count!=operates)
				throw new RuntimeException();
			return current!=null;
		}
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		public Item next()
		{
			if(count!=operates)
				throw new RuntimeException();
			if(isEmpty())
				throw new RuntimeException();
			Item item=current.item;
			current=current.next;
			return item;
		}
	}
	public Item peek()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		return first.item;
	}
	
}
