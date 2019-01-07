package com.tongji.algorithms_2_1;

import java.util.Arrays;

public class Exe_2_5_14 implements Comparable<Exe_2_5_14>
{
	private  String x;
	private String y;
	private String z;
	
	public Exe_2_5_14(String s)
	{
		String [] strings=s.split("\\.");
		x=strings[0];
		y=strings[1];
		z=strings[2];
	}
	public int compareTo(Exe_2_5_14 that)
	{
		if(this.z.compareTo(that.z)>0)
			return +1;
		if(this.z.compareTo(that.z)<0)
			return -1;
		if(this.y.compareTo(that.y)>0)
			return +1;
		if(this.y.compareTo(that.y)<0)
			return -1;
		if(this.x.compareTo(that.x)>0)
			return +1;
		if(this.x.compareTo(that.x)<0)
			return -1;
		return 0;
	}
	public String toString()
	{
		return z+"."+y+"."+x;
	}
	public static void main(String[] args)
	{
		Exe_2_5_14 [] e=new Exe_2_5_14 [5];
		e[0]=new Exe_2_5_14("116.1.1");
		e[1]=new Exe_2_5_14("115.10.3");
		e[2]=new Exe_2_5_14("115.10.2");
		e[3]=new Exe_2_5_14("115.1.1");
		e[4]=new Exe_2_5_14("115.3.1");
		Arrays.sort(e);
		for(Exe_2_5_14 x:e)
			System.out.println(x);
		
	}
}
