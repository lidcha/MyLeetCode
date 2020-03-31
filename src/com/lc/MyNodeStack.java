package com.lc;

/**
* @author 
* @createDate ：2020年3月26日
*/
public class MyNodeStack<T> {
	class Node<T>{
		private T data;//数据
		private Node<T> next;//指向下个节点
		public Node(T data){
			this.data = data;
		}
		public Node<T> getNext(){
			return this.next;
		}
		public void setNext(Node<T> node){
			this.next = node;
		}
		public T getData(){
			return this.data;
		}
		public void setData(T d){
			this.data = d;
		}
		
	}
	private Node<T> top = null;
	public MyNodeStack(){
		this.top = null;
	}
	//判断栈是否为空
	public boolean isEmpty(){
		if(top ==null)
			return true;
		else
			return false;
	}
	
	//压栈
	public boolean push(T value){
		Node<T> node = new Node<T>(value);
		node.setNext(top);
		top = node;
		return true;
	}
	
	//出栈
	public T pop(){
		if(top == null)
			return null;
		T temp = top.data;
		top = top.getNext();
		return temp;
	}
	public T peek(){
		if(top==null)
			return null;
		return top.getData();
	}
	
	public static void main(String[] args) {
		MyNodeStack<String> stack = new MyNodeStack<>();
		stack.push("第一个入栈");
		stack.push("第二个入栈");
		stack.push("第三个入栈");
		stack.push("第四个入栈");
		stack.push("第五个入栈");
		
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
	
	
	
	
	
	
}
