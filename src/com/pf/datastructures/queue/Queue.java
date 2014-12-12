package com.pf.datastructures.queue;

public class Queue {

	private int rear;
	private int front;
	private long[] data;
	private int elements;
	
	/*public Queue(int size) {
		front = 0;
		rear = -1;
		data = new long[size];
	}
	
	public boolean isEmpty() {
		return elements == 0;
	}
	
	public boolean isFull() {
		return elements == data.length;
	}
	
	public void insert(long val) {
		elements++;
		rear = (rear + 1) % data.length;
		data[rear] = val;
	}
	
	public long remove() {
		elements--;
		long result = data[front];
		front = (front + 1) % data.length;
		return result;
	}*/
	
	//
	public Queue(int size) {
		rear = 0;
		front = 0;
		data = new long[size];
	}
	
	public boolean isEmpty() {
		return elements == 0;
	}
	
	public boolean isFull() {
		return elements == data.length;
	}
	
	public void insert(long val) {
		if ( isFull() ) {
			System.out.println("Queue is full");
			return;
		}
		
		elements++;
		data[rear] = val;
		rear = (rear + 1) % data.length;
	}
	
	public long remove() {
		if ( isEmpty() ) {
			System.out.println("Queue is empty");
			return -1;
		}
		
		elements--;
		long toDel = data[front];
		front = (front + 1) % data.length;
		
		return toDel;
	}
	//
	
	public void display() {		
		for ( int i = 0; i < data.length; i++ ) {
			System.out.print(data[i]);
			if ( i == front ) {
				System.out.print(" front");
			} 
			
			if ( i == rear ) {
				System.out.print(" rear");
			} 
			
			System.out.println("");
		}
		
		System.out.println("---------------------------");
	}
}
