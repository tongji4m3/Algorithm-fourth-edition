package com.tongji.algorithms_2_1;

import java.util.Arrays;

public class Exe_2_5_10 implements Comparable<Exe_2_5_10>
{
	private  int x;
	private int y;
	private int z;
	
	public Exe_2_5_10(String s)
	{
		String [] strings=s.split("\\.");
		x=Integer.parseInt(strings[0]);
		y=Integer.parseInt(strings[1]);
		z=Integer.parseInt(strings[2]);
	}
	public int compareTo(Exe_2_5_10 that)
	{
		if(this.x>that.x)
			return +1;
		if(this.x<that.x)
			return -1;
		if(this.y>that.y)
			return +1;
		if(this.y<that.y)
			return -1;
		if(this.z>that.z)
			return +1;
		if(this.z<that.z)
			return -1;
		return 0;
	}
	public String toString()
	{
		return x+"."+y+"."+z;
	}
	public static void main(String[] args)
	{
		Exe_2_5_10 [] e=new Exe_2_5_10 [5];
		e[0]=new Exe_2_5_10("116.1.1");
		e[1]=new Exe_2_5_10("115.10.3");
		e[2]=new Exe_2_5_10("115.10.2");
		e[3]=new Exe_2_5_10("115.1.1");
		e[4]=new Exe_2_5_10("115.3.1");
		Arrays.sort(e);
		for(Exe_2_5_10 x:e)
			System.out.println(x);
		
	}
}













