package com.tongji.algorithms_2_1;

import java.util.Arrays;

public class Exe_2_5_8
{
	private static class Record implements Comparable<Record>
	{
		String word;
		int frequence;
		public Record(String word,int frequence)
		{
			this.word=word;
			this.frequence=frequence;
		}
		public int compareTo(Record that)
		{
			return this.frequence-that.frequence;
		}
		public String toString()
		{
			return word+" "+frequence;
		}
	}
	public static void main(String[] args)
	{
		String [] strings="after thought afterthought ab cd abcd a a aaa aa aa".split(" ");
		Arrays.sort(strings);
		Record [] records=new Record[strings.length];
		String word=strings[0];
		int freq = 1;
		int m=0;
		for (int i = 1; i <strings.length ; i++) 
		{
			if(!word.equals(strings[i]))
			{
				records[m++]=new Record(word,freq);
				word=strings[i];
				freq=0;
			}
			freq++;
		}
		records[m++] = new Record(word, freq);
		Arrays.sort(records, 0,m);
		for (int i = m-1; i >=0 ; i--) 
		{
			System.out.println(records[i]+" ");
		}
	}
}
