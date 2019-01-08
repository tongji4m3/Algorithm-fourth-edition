package com.tongji.algorithms_1_3;

import edu.princeton.cs.algs4.StdIn;

public class Exe_3_1_1
{
	public static void main(String[] args)
	{
		ST<String,Double> grades=new ST<>();
		grades.put("A",  4.00);
	    grades.put("B",  3.00);
	    grades.put("C",  2.00);
	    grades.put("D",  1.00);
	    grades.put("F",  0.00);
	    grades.put("A+", 4.33);
	    grades.put("B+", 3.33);
	    grades.put("C+", 2.33);
	    grades.put("A-", 3.67);
	    grades.put("B-", 2.67);
	    int N=0;
	    double total=0.0;
	    for ( N = 0; !StdIn.isEmpty() ; N++) 
		{
			String grade=StdIn.readString();
			double value=grades.get(grade);
			total+=value;
		}
	    double gpa=total/N;
	    System.out.println(gpa);
	}
}

