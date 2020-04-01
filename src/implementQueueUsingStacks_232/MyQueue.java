package implementQueueUsingStacks_232;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description
 * @createDate ：2020年4月1日
 */
public class MyQueue {

	Queue<Integer> q1 = null;
	Queue<Integer> q2 = null;

	/** Initialize your data structure here. */
	public MyQueue() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		if (q1.isEmpty())
			q1.add(x);
		else {
			while (!q1.isEmpty()) {
				int element = q1.poll();
				q2.add(element);
			}
			q2.add(x);
			while(!q2.isEmpty()){
				int element = q2.poll();
				q1.add(element);
			}
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if(q1.isEmpty())	return (Integer)null;
		else
			return q1.poll();
	}

	/** Get the front element. */
	public int peek() {
		if(q1.isEmpty())	return (Integer)null;
		else
			return q1.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return q1.isEmpty();
	}
}
