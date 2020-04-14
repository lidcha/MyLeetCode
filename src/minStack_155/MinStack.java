package minStack_155;

import java.util.LinkedList;

/**
 * @author
 * @createDate ：2020年3月28日
 */
public class MinStack {
	LinkedList<Integer> linkedList = null;

	/** initialize your data structure here. */
	public MinStack() {
		linkedList = new LinkedList<>();
	}

	public void push(int x) {
		linkedList.add(x);
	}

	public void pop() {
		if (linkedList.isEmpty())
			return;

		linkedList.removeLast();
	}

	public int top() {
		if (linkedList.isEmpty())
			return (Integer) null;
		return linkedList.getLast();
	}

	public int getMin() {
		int min = Integer.MAX_VALUE;
		for (Integer num : linkedList) {
			if (num < min)
				min = num;
		}
		return min;
	}
}
