package com.pf.datastructures.queue;

public class Dequeue {

	private int front;
	private int rear;
	private long[] data;
	private int elements;
	
	public Dequeue(int size) {
		front = 0;
		rear = -1;
		elements = 0;
		data = new long[size];
	}
	
	public void insertLeft(long val) throws Exception {
		if ( isFull() ) {
			throw new Exception("IS_FULL");
		}
		
		elements++;
		rear = (rear + 1) % data.length;
		data[rear] = val;
	}
	
	public void insertRight(long val) throws Exception {
		if ( isFull() ) {
			throw new Exception("IS_FULL");
		}
		
		elements++;
		if ( --front < 0 ) {
			front = data.length - 1;
		}
		
		data[front] = val;
	}
	
	public long removeLeft() throws Exception {
		if ( isEmpty() ) {
			throw new Exception("IS_EMPTY");
		}
		
		elements--;
		long temp = data[rear];
		if ( --rear < 0 ) {
			rear = data.length - 1;
		}
		
		return temp;
	}
	
	public long removeRight() throws Exception {
		if ( isEmpty() ) {
			throw new Exception("IS_EMPTY");
		}
		
		elements--;
		long temp = data[front];
		front = (front + 1) % data.length;
		return temp;
	}
	
	public boolean isEmpty() {
		return elements == 0;
	}
	
	public boolean isFull() {
		return elements == data.length;
	}
	
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
