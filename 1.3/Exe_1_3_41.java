package com.tongji.test_1_3;

import edu.princeton.cs.algs4.Queue;

public class Exe_1_3_41
{
	//假设本类是Queue类,懒得再实现一遍了
	public Queue (Queue<Item> queue)
	{
		for(Item item:queue)
		{
			this.enqueue(item);
		}
	}
}
