package com.tongji.test_1_4;

import edu.princeton.cs.algs4.Stack;

public class Exe_1_4_30<Item>
{
	//用上题实现的steque
	//steque代表队列头部,stack代表队列尾部,想象它们背靠背
	private Exe_1_4_29<Item> steque=new Exe_1_4_29<>();
	private Stack<Item> stack=new Stack<>();
	
	public void pushLeft(Item item)
	{
		steque.push(item);
	}
	public Item popLeft()
	{
		if(steque.isEmpty())
			stackToSteque();
		return steque.pop();
	}
	public void pushRight(Item item)
	{
		if(stack.isEmpty())
			steque.enqueue(item);
		else
			stack.push(item);
	}
	public Item popRight()
	{
		if(stack.isEmpty())
			stequeToStack();
		return stack.pop();
	}
	public boolean isEmpty()
	{
		return stack.isEmpty()&&steque.isEmpty();
	}
	public int size()
	{
		return stack.size()+steque.size();
	}
	private void stackToSteque()
	{
		while(!stack.isEmpty())
			steque.push(stack.pop());
	}
	private void stequeToStack()
	{
		while(!steque.isEmpty())
		{
			stack.push(steque.pop());
		}
	}
	public void print()
	{
		for()
	}
	public static void main(String[] args)
	{
		Exe_1_4_30<Integer> e=new Exe_1_4_30();
		for (int i = 0; i <5 ; i++) 
		{
			e.pushLeft(i);
		}
	}
	
}
