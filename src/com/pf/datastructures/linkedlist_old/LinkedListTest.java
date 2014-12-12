package com.pf.datastructures.linkedlist_old;

import java.util.Iterator;

//import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator<Integer> it = list.iterator();
		while ( it.hasNext() ) {
			System.out.println(it.next());
		}
	}

}
