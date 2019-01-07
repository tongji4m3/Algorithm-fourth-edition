package com.tongji.algorithms_1_5;


public class Exe_2_4_26
{
	private void swim(int k)
	{
		Key key=pq[k];
		while(k>1 && pq[k/2].compareTo(key)<0)
		{
			pq[k]=pq[k/2];
			k/=2;
		}
		pq[k]=key;
	}
	private void sink(int k)
	{
		Key key=pq[k];
		while(2*k <= N)
		{
			int j=2*k;
			if(j<N && less(j,j+1))
				j++;
			if(pq[j].compareTo(key)<0)
				break;
			pq[k]=pq[j];
			k=j;
		}
		pq[k]=key;
	}
}

