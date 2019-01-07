
package com.tongji.algorithms_2_1;

import java.io.File;
import java.util.Arrays;

public class Exe_2_5_28
{
	public static void main(String[] args)
	{
		File directory=new File(args[0]);
		if(!directory.exists())
			return;
		if(!directory.isDirectory())
		{
			System.out.println(args[0]);
			return;
		}
		File [] files=directory.listFiles();
		if(files==null)
		{
			System.out.println("could not read files");
			return;
		}
		Arrays.sort(files);
		for (int i = 0; i <files.length ; i++) 
		{
			System.out.println(files[i].getName());
		}
	}
}
