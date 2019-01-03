package com.tongji.test_1_3;

import edu.princeton.cs.algs4.Stack;

public class Exe_1_3_42
{
	public Stack(Stack<Item> stack)
	{
		//用临时栈存储,连续颠倒两次
		Stack<Item> stack2=new Stack<>();
		for(Item item : stack)
		{
			stack2.push(item);
		}
		for(Item item : stack2)
		{
			this.push(item);
		}
	}
}
