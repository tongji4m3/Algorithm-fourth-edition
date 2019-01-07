package com.tongji.algorithms_1_5;

public class Exe_2_4_3_unorderArray<Key extends Comparable<Key>>
{
	private Key[] pq;
	private int N;

	public Exe_2_4_3_unorderArray(int capacity)
	{
		pq = (Key[]) new Comparable[capacity];
		N = 0;
	}

	public boolean isEmpty()
	{
		return N == 0;
	}

	public int size()
	{
		return N;
	}

	public void insert(Key key)
	{
		pq[N++] = key;
	}

	public Key delMax()
	{
		int max = 0;
		for (int i = 1; i < N; i++)
		{
			if (less(max, i))
				max = i;
		}
		exch(max, N - 1);
		return pq[--N];
	}

	private boolean less(int i, int j)
	{
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j)
	{
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
}
