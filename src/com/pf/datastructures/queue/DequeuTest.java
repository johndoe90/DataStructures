package com.pf.datastructures.queue;

public class DequeuTest {
	public static void main(String[] args) throws Exception {
		Dequeue queue = new Dequeue(10);
		
		System.out.println("isEmpty: " + queue.isEmpty());
		System.out.println("isFull: " + queue.isFull());
		System.out.println("-----------------");
		
		queue.insertLeft(1);
		queue.insertRight(2);
		queue.insertRight(3);
		queue.insertLeft(1);
		queue.insertRight(2);
		queue.insertRight(3);
		queue.insertLeft(1);
		queue.insertRight(2);
		queue.insertRight(3);
		queue.insertLeft(1);

		System.out.println(queue.removeRight());
		System.out.println(queue.removeRight());
		System.out.println(queue.removeRight());
		System.out.println(queue.removeRight());
		
		//queue.display();
	}
}
