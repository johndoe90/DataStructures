package com.pf.datastructures.arraylist;

import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		Iterator<Integer> it = list.iterator();
		while ( it.hasNext() ) {
			System.out.println(it.next());
		}
		
		System.out.println("--------------------------------------");
		
		list.delete(4);
		
		it = list.iterator();
		while ( it.hasNext() ) {
			System.out.println(it.next());
		}
	}

}
