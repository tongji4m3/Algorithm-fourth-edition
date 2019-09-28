package com.tongji.test_1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exe_1_3_14<Item> implements Iterable<Item>
{
    private Item[] q;
    private int N;
    private int first, last;//last指向实际元素的下一个,类似N

    public ResizingArrayQueue()
    {
        q = (Item[]) new Object[2];
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    private void resize(int capacity)
    {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++)
        {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
        last=N;
    }

    public void enqueue(Item item)
    {
        if(N==q.length)
        {
            resize(2*q.length);
        }
        q[last++] = item;
        if(last==q.length)
        {
            last = 0;
        }
        ++N;
    }
    public Item dequeue()
    {
        if(isEmpty())
        {
            throw new RuntimeException();
        }
        Item item = q[first];
        q[first] = null;
        --N;
        ++first;
        if(first==q.length)
        {
            first = 0;
        }
        if(N>0 && N==q.length/4)
        {
            resize(q.length / 2);
        }
        return item;
    }

    public Item peek()
    {
        if(isEmpty())
        {
            throw new RuntimeException();
        }
        return q[first];
    }

    public Iterator<Item> iterator()
    {
        return new Iterator<Item>()
        {
            private int i=0;
            @Override
            public boolean hasNext()
            {
                return i<N;
            }

            public void remove()
            {
                throw new UnsupportedOperationException();
            }

            @Override
            public Item next()
            {
                if(isEmpty())
                {
                    throw new RuntimeException();
                }
                Item item = q[(i + first) % q.length];
                ++i;
                return item;
            }
        };
    }
}

