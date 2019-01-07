package com.tongji.algorithms_1_5;

public class Exe_2_4_30<Key extends Comparable<Key>>
{
	private MaxPQ<Key> maxPQ;
	private MinPQ<Key> minPQ;
	private Key median;
	private int N;

	public Exe_2_4_30()
	{
		maxPQ = new MaxPQ<>();
		minPQ = new MinPQ<>();
	}

	public Exe_2_4_30(int capacity)
	{
		// 各存储一半数组(先减去中位数)
		maxPQ = new MaxPQ<>((capacity - 1) / 2);
		minPQ = new MinPQ<>((capacity - 1) / 2);
	}

	public Exe_2_4_30(Key[] keys)
	{
		maxPQ = new MaxPQ<>();
		minPQ = new MinPQ<>();
		if (keys.length == 0)
		{
			return;
		}
		N = keys.length;
		median = keys[0];
		for (int i = 1; i < keys.length; i++)
		{
			if (median.compareTo(keys[i]) < 0)
				minPQ.insert(keys[i]);// 存比median大的
			else
				maxPQ.insert(keys[i]);
		}
		updateMedian();// 如果左右两堆数量差大于一就继续,直到平衡为止
	}

	public void insert(Key key)
	{
		if (N == 0)
		{
			N++;
			median = key;
			return;
		}
		if (key.compareTo(median) < 0)
			maxPQ.insert(key);
		else
			minPQ.insert(key);
		N++;
		updateMedian();// 调整
	}

	public Key delMedian()
	{
		if (isEmpty())
			throw new NoSuchElementException();
		Key median = this.median;
		if (N == 1)
		{
			N--;
			this.median = null;
			return median;
		}
		if (minPQ.size() > maxPQ.size())
		{
			median = minPQ.delMin();
		} else
			median = maxPQ.delMax();
		N--;
		return median;
	}

	public Key median()
	{
		return median;
	}

	public boolean isEmpty()
	{
		return N == 0;
	}

	public void updateMedian()
	{
		while (maxPQ.size() - minPQ.size() > 1)
		{
			minPQ.insert(median);
			median = maxPQ.delMax();
		}
		while (minPQ.size() - maxPQ.size() > 1)
		{
			maxPQ.insert(median);
			median = minPQ.delMin();
		}
	}
}
