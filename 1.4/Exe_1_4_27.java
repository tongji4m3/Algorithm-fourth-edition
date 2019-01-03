package com.tongji.test_1_4;

import edu.princeton.cs.algs4.Stack;

public class Exe_1_4_27<Item>
{
	//两个栈 从1进,2出
	private Stack<Item> stack1=new Stack<>();
	private Stack<Item> stack2=new Stack<>();
	
	public void enquue(Item item)
	{
		stack1.push(item);
	}
	
	public Item dequeue() 
	{
		if(stack1.isEmpty() && stack2.isEmpty())
			throw new RuntimeException();
		if(stack2.isEmpty())
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
		}
		Item item=stack2.pop();
		return item;
	}
}


