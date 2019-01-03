package com.tongji.test_1_3;

import com.tongji.test_1_3.Exe_1_3_50.Node;

public class Exe_1_3_47
{
	public void catenation(Stack<Item> stack) {
		if (stack.first != null) {
			Stack<Item> temp = new Stack<>(stack);
			Node last = temp.first;
			while (last.next != null) {
				last = last.next;
			}
			last.next = first;
			first = temp.first;
		}
	}

}
