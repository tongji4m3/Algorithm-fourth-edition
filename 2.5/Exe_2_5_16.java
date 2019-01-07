package com.tongji.algorithms_2_1;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.StdIn;

public class Exe_2_5_16
{
     
	public static final Comparator<String> CANDIDATE_ORDER=new Order();
	public static void main(String[] args)
	{
		String [] candidates=StdIn.readAll().toUpperCase().split("\\n+");
		int N=candidates.length;
		Arrays.sort(candidates, Exe_2_5_16.CANDIDATE_ORDER);
		for (int i = 0; i <N ; i++) 
		{
			System.out.println(candidates[i]);
		}
	}
	public static class Order implements Comparator<String>
	{
		private String string="RWQOJMVAHBSGZXNTCIEKUPDYFL";
		public int compare(String v,String w)
		{
			if(v==w)
				return 0;
			int length=Math.min(v.length(), w.length());
			for (int i = 0; i <length ; i++) 
			{
				int x=string.indexOf(v.charAt(i));
				int y=string.indexOf(w.charAt(i));
				
				if(x<y)
					return -1;
				else if(x>y)
					return +1;
			}
			return v.length()-w.length();
		}
	}
}
