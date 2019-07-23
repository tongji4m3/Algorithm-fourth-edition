package com.tongji.test_1_3;

import edu.princeton.cs.algs4.Stack;

public class Exe_1_3_9
{
	public static void main(String[] args)
	{
		String s="1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
		Stack<String> vals=new Stack<>();
		Stack<String> ops=new Stack<>();
		String [] strings=s.split("\\s+");
		for (int i = 0; i <strings.length ; i++) 
		{
			if(strings[i].equals("+")||strings[i].equals("-")||strings[i].equals("*")||strings[i].equals("/")||strings[i].equals("sqrt"))
				ops.push(strings[i]);
			else if(strings[i].equals(")"))
			{
				String string="(";
				String v=vals.pop();//ÓÒ±ßµÄ
				String w=vals.pop();//×ó±ßµÄ²Ù×÷Êý
				string+=w+ops.pop()+v+")";
				vals.push(string);
			}
			else 
				vals.push(strings[i]);
		}
		System.out.println(vals.pop());
	}
}
