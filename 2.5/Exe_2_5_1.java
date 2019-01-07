package com.tongji.algorithms_2_1;

public class Exe_2_5_1
{
	private String string;
	public int compareTo(String that)
	{
		if(string==that) return 0;//如果字符串内容相等,就不用比较了
		int n=Math.min(string.length(), that.length());
		for (int i = 0; i <n ; i++) 
		{
			if(string.charAt(i)<that.charAt(i))
				return -1;
			else if(string.charAt(i)>that.charAt(i))
				return +1;
		}
		return string.length()-that.length();
	}
}
