package com.pf.datastructures.linkedlist;

public class LinkedListTest {
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();

		list.insertLast(1);	
		list.insertLast(2);
		list.insertLast(3);
		list.insertFirst(1);	
		list.insertFirst(2);
		list.insertFirst(3);
		
		list.display();
		
		list.removeFirst();
		list.removeLast();
		
		list.display();
		
		list.insertFirst(4);
		list.insertLast(4);
		
		list.display();
		
		list.insertAfter(0, 99);
		list.display();
	}	
}
