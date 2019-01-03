package com.tongji.test_1_4;

import edu.princeton.cs.algs4.Stack;

public class Exe_1_4_31<Item>
{
	/*
	  三个栈分别命名为左中右,左侧栈和右侧栈负责模拟队列，

	由于是双向队列，左栈和右栈会频繁的倒来倒去，因此每次都只倒一半的元素可以有效减少开销。

	有一侧栈为空时，另一侧栈中上半部分先移动到中间栈中，下半部分倒到另一侧栈里，再从中间栈拿回上半部分元素。*/
	Stack<Item> left=new Stack<>();
	Stack<Item> middle=new Stack<>();
	Stack<Item> right=new Stack<>();
	
	public void pushLeft(Item item)
	{
		left.push(item);
	}
	public void pushRight(Item item)
	{
			right.push(item);
	}
	public boolean isEmpty()
	{
		return left.isEmpty()&&middle.isEmpty()&&right.isEmpty();
	}
	public Item popLeft()
	{
		if(isEmpty())
			throw new RuntimeException();
		if(left.isEmpty())
		{
			move(right, left);
		}
		return left.pop();
	}
	public Item popRight()
	{
		if(right.isEmpty())
			move(left, right);
		return right.pop();
	}
	private void move(Stack<Item> from,Stack<Item> to)
	{
		//只把一半放过去,确保左右弹栈时不用一直挪来挪去
		int N=from.size();
		for (int i = 0; i <N/2 ; i++) 
		{
			middle.push(from.pop());
		}
		while(!from.isEmpty())
		{
			to.push(from.pop());
		}
		while(!middle.isEmpty())
		{
			from.push(middle.pop());
		}
	}
	
}
