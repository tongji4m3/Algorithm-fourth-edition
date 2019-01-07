package com.tongji.algorithms_2_1;

import java.util.Comparator;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdIn;

public class Exe_2_5_27
{
	private Exe_2_5_27()
	{

	}

	public static void sort(Comparable[] a)
	{
		int N = a.length;
		for (int i = 1; i < N; i++)
		{
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
			{
				exch(a, j, j - 1);
			}
			assert isSorted(a, 0, i);
		}
		assert isSorted(a);
	}

	public static void sort(Comparable[] a, int lo, int hi)
	{
		// 只将lo到hi排好序
		for (int i = lo + 1; i < hi; i++)
		{
			for (int j = i; j > lo && less(a[j], a[j - 1]); j--)
			{
				exch(a, j, j - 1);
			}
		}
		assert isSorted(a, lo, hi);
	}

	// 有比较器的排序
	public static void sort(Object[] a, Comparator comparator)
	{
		for (int i = 1; i < a.length; i++)
		{
			for (int j = i; j > 0 && less(a[j], a[j - 1], comparator); j--)
			{
				exch(a, j, j - 1);
			}
		}
		assert isSorted(a, comparator);
	}

	public static void sort(Object[] a, int lo, int hi, Comparator comparator)
	{
		for (int i = lo + 1; i < hi; i++)
		{
			for (int j = i; j > lo && less(a[j], a[j - 1], comparator); j--)
			{
				exch(a, j, j - 1);
			}
		}
		assert isSorted(a, lo, hi, comparator);
	}

	public static int[] indexSort(Comparable[] a)
	{
		// 只改变了索引数组
		int N = a.length;
		int[] index = new int[N];
		for (int i = 0; i < N; i++)
		{
			index[i] = i;
		}
		for (int i = 1; i < N; i++)
		{
			for (int j = i; j > 0 && less(a[index[j]], a[index[j - 1]]); j--)
			{
				exch(index, j, j - 1);
			}
		}
		return index;
	}

	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}

	private static boolean less(Object v, Object w, Comparator comparator)
	{
		return comparator.compare(v, w) < 0;
	}

	private static void exch(Object[] a, int i, int j)
	{
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static void exch(int[] a, int i, int j)
	{
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static boolean isSorted(Comparable[] a)
	{
		return isSorted(a, 0, a.length);
	}

	// is the array a[lo..hi) sorted
	private static boolean isSorted(Comparable[] a, int lo, int hi)
	{
		for (int i = lo + 1; i < hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	private static boolean isSorted(Object[] a, Comparator comparator)
	{
		return isSorted(a, 0, a.length, comparator);
	}

	private static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator)
	{
		for (int i = lo + 1; i < hi; i++)
			if (less(a[i], a[i - 1], comparator))
				return false;
		return true;
	}

	private static void show(Comparable[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args)
	{
		String[] a = StdIn.readAllStrings();
		Insertion.sort(a);
		show(a);
	}
}
