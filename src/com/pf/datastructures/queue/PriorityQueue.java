package com.pf.datastructures.queue;

public class PriorityQueue {

	private int top;
	private int[] data;
	
	public PriorityQueue(int size) {
		top = -1;
		data = new int[size];
	}
	
	public int peek() {
		return data[top];
	}
	
	public void insert(int val) {
		int i = ++top;
		while ( i > 0 && data[i-1] < val ) {
			data[i] = data[--i];
		}
		
		data[i] = val;
	}
	
	public int remove() {
		return data[top--];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == data.length - 1;
	}
	
	public void display() {
		for ( int i = data.length - 1; i >= 0; i-- ) {
			System.out.print(data[i]);
			System.out.println(i == top ? " top" : "");
		}
		
		System.out.println("-------------------------------");
	}
}
