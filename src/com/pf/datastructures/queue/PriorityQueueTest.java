package com.pf.datastructures.queue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue(10);
		
		System.out.println("isEmpty: " + queue.isEmpty());
		System.out.println("isFull: " + queue.isFull());
		
		queue.insert(5);
		queue.insert(7);
		queue.insert(3);
		
		System.out.println("isEmpty: " + queue.isEmpty());
		System.out.println("isFull: " + queue.isFull());
		
		queue.display();
		
		System.out.println("peek: " + queue.peek());
		System.out.println("remove: " + queue.remove());
		System.out.println("remove: " + queue.remove());
		System.out.println("remove: " + queue.remove());
		
		System.out.println("isEmpty: " + queue.isEmpty());
		System.out.println("isFull: " + queue.isFull());
		queue.display();
		
		queue.insert(9);
		queue.display();
	}
}
