package com.tongji.algorithms_2_1;

import edu.princeton.cs.algs4.Inversions;
import edu.princeton.cs.algs4.StdRandom;

public class Exe_2_5_19
{
	//√ª‘ı√¥ø¥∂Æ
	public static int[] permutation(int n)
	{
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
		{
			a[i] = i;
		}
		StdRandom.shuffle(a);
		return a;
	}

	public static long distance(int[] a, int[] b)
	{
		if (a.length != b.length)
			throw new RuntimeException();
		int N = a.length;
		int[] ainv = new int[N];
		for (int i = 0; i < N; i++)
		{
			ainv[a[i]] = i;
		}
		Integer[] bnew = new Integer[N];
		for (int i = 0; i < N; i++)
			bnew[i] = ainv[b[i]];
		return Inversions.count(bnew);
	}

	public static void main(String[] args)
	{
		int N = 6;
		int[] a = permutation(N);
		int[] b = permutation(N);

		for (int i = 0; i < N; i++)
		{
			System.out.println(a[i] + " " + b[i]);
		}
		System.out.println();
		System.out.println(distance(a, b));

	}
}
