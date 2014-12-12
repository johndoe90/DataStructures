package com.pf.datastructures.stack;

public class Stack {
	
	private int top;
	private long[] data;
	
	public Stack(int maxSize) {
		top = -1;
		data = new long[maxSize];
	}
	
	public long peek() {
		return data[top];
	}
	
	public void push(long val) {
		data[++top] = val;
	}
	
	public long pop() {
		return data[top--];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == data.length - 1;
	}
}
