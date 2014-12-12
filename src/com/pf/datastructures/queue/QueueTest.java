package com.pf.datastructures.queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue queue = new Queue(10);
		
		/*System.out.println("isEmpty: " + queue.isEmpty());
		
		queue.insert(1);
		queue.insert(2);
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println("isFull: " + queue.isFull());
		System.out.println("-----------------");
		
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		queue.insert(6);
		queue.insert(7);
		queue.insert(8);
		queue.insert(9);
		queue.insert(10);
		queue.insert(11);
		queue.insert(12);
		
		System.out.println("isFull: " + queue.isFull());*/
		
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		queue.insert(1);
		queue.insert(6);
		queue.insert(7);
		queue.insert(8);
		queue.insert(9);
		
		while ( !queue.isEmpty() ) {
			System.out.println(queue.remove());
		}
		
		//queue.display();
	}
}
