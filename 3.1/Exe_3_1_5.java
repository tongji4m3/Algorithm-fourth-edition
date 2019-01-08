package com.tongji.algorithms_1_3;

public class Exe_3_1_5<Key, Value>
{
	private int N; 
	private Node first;

	// a helper linked list data type
	private class Node
	{
		private Key key;
		private Value val;
		private Node next;

		public Node(Key key, Value val, Node next)
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	public Exe_3_1_5()
	{
	}

	public int size()
	{
		return N;
	}
	public boolean isEmpty()
	{
		return size() == 0;
	}
	public boolean contains(Key key)
	{
		if (key == null)
			throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	public Value get(Key key)
	{
		if (key == null)
			throw new IllegalArgumentException("argument to get() is null");
		for (Node x = first; x != null; x = x.next)
		{
			if (key.equals(x.key))
				return x.val;
		}
		return null;
	}

	public void put(Key key, Value val)
	{
		if (key == null)
			throw new IllegalArgumentException("first argument to put() is null");
		if (val == null)
		{
			delete(key);
			return;
		}

		for (Node x = first; x != null; x = x.next)
		{
			if (key.equals(x.key))
			{
				x.val = val;
				return;
			}
		}
		first = new Node(key, val, first);
		N++;
	}
	public void delete(Key key)
	{
		if (key == null)
			throw new IllegalArgumentException("argument to delete() is null");
		first = delete(first, key);
	}

	private Node delete(Node x, Key key)
	{
		if (x == null)
			return null;
		if (key.equals(x.key))
		{
			N--;
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}

	public Iterable<Key> keys()
	{
		Queue<Key> queue = new Queue<Key>();
		for (Node x = first; x != null; x = x.next)
			queue.enqueue(x.key);
		return queue;
	}
	public static void main(String[] args)
	{
		Exe_3_1_5<String, Integer> st = new Exe_3_1_5<String, Integer>();
		for (int i = 0; !StdIn.isEmpty(); i++)
		{
			String key = StdIn.readString();
			st.put(key, i);
		}
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}
}
