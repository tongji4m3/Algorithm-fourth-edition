package com.tongji.test_1_3;

import edu.princeton.cs.algs4.Stack;

public class Exe_1_3_11
{
	public static void main(String[] args)
	{
		String s="1 2 + 3 4 - 5 6 - * *";
		Stack<Integer> vals=new Stack<>();
		Stack<String> ops=new Stack<>();
		String [] strings=s.split("\\s+");
		for (int i = 0; i <strings.length ; i++) 
		{
			
			if(strings[i].equals("+"))
			{
				int v=vals.pop();
				int w=vals.pop();
				vals.push(w+v);
			}
			else if(strings[i].equals("-"))
			{
				int v=vals.pop();
				int w=vals.pop();
				vals.push(w-v);
			}
			else if(strings[i].equals("*"))
			{
				int v=vals.pop();
				int w=vals.pop();
				vals.push(w*v);
			}
			else if(strings[i].equals("/"))
			{
				int v=vals.pop();
				int w=vals.pop();
				vals.push(w/v);
			}
			else 
				vals.push(Integer.parseInt(strings[i]));
		}
		System.out.println(vals.pop());
		//3
	}
}
