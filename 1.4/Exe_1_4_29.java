package com.tongji.test_1_4;


import edu.princeton.cs.algs4.Stack;

public class Exe_1_4_29<Item>
{
	//两个栈实现的steque(以栈为目标的队列) ,包含push,pop,enqueue操作
	//与Exe_1_4_27 两个栈实现队列差不多
	//总的思路是:如果不进行enqueue操作的话,push与pop只用到了stack2
	//如果enqueue了,先把2全部倒入1中,加入元素,再倒入2中,保证enqueue的在2的最末端
	private Stack<Item> stack1=new Stack<>();
	private Stack<Item> stack2=new Stack<>();
	
	public void push(Item item)
	{
		stack2.push(item);
	}
	public boolean isEmpty()
	{
		return stack1.isEmpty()&&stack2.isEmpty();
	}
	public int size()
	{
		return stack1.size()+stack2.size();
	}
	public Item pop()
	{
		return stack2.pop();
	}
	public void enqueue(Item item)
	{
		reverse2();
		stack1.push(item);
		reverse1();
	}
	//把stack1中元素压stack2中
	private void reverse1()
	{
		while(!stack1.isEmpty())
		{
			stack2.push(stack1.pop());
		}
	}
	//把stack2中元素压stack1中
	private void reverse2()
	{
		while(!stack2.isEmpty())
		{
			stack1.push(stack2.pop());
		}
	}
	public void print()
	{
		for(Item item:stack2)
		{
			System.out.print(item+" ");
		}
	}
	public static void main(String[] args)
	{
		Exe_1_4_29<Integer> e=new Exe_1_4_29<>();
		for (int i = 0; i <5 ; i++) 
		{
			e.push(i);
		}
		e.pop();
		e.enqueue(6);
		e.print();
	}
}
