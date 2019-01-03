package com.tongji.test_1_3;

import java.io.File;

import edu.princeton.cs.algs4.Queue;

public class Exe_1_3_43
{
	public static void print(String path,int depth,Queue<String> queue)
	{
		File file=new File(path);
		File [] list=file.listFiles();
		for(File newFile :list)
		{
			StringBuilder s=new StringBuilder("    ");
			for (int i = 0; i <depth ; i++) 
			{
				s.append("    ");
			}
			s.append(newFile.getName());
			queue.enqueue(s.toString());
			if(newFile.isDirectory())
				print(newFile.getAbsolutePath(), depth+1,queue);
		}
	}
	public static void main(String[] args)
	{
//		String path=args[0];
		String path="F:\\XXXXX";
		Queue<String> queue=new Queue<>();
		queue.enqueue(path);
		print(path, 0,queue);
		while(!queue.isEmpty())
			System.out.println(queue.dequeue());
	}	
}
