package com.tongji.test_1_4;

import edu.princeton.cs.algs4.Queue;

public class Exe_1_4_28<Item>
{
	private Queue<Item> queue=new Queue<>();
	//用队列实现栈
	public void push(Item item)
	{
		queue.enqueue(item);
	}
	public Item pop()
	{
		//将队列所以元素出列再入列,除了最后一个元素
		for (int i = 0; i < queue.size()-1 ; i++) 
		{
			queue.enqueue(queue.dequeue());
		}
		Item item=queue.dequeue();
		return item;
	}
	public void print()
	{
		for(Item item:queue)
		{
			System.out.print(item+" ");
		}
	}
	public static void main(String[] args)
	{
		Exe_1_4_28<Integer> e=new Exe_1_4_28();
		for (int i = 0; i <5 ; i++) 
		{
			e.push(i);
		}
		System.out.println(e.pop());
		e.print();
	}
}
