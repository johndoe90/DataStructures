package com.pf.datastructures.heap;

public class HeapTest {
	
	public static void main(String[] args) {
		Heap<Integer, Integer> heap = new Heap<>(40);
		
		heap.insert(15, 15);
		heap.insert(17, 17);
		heap.insert(25, 25);
		heap.insert(35, 35);
		heap.insert(20, 20);
		heap.insert(21, 21);
		heap.insert(39, 39);
		heap.insert(50, 50);
		heap.insert(75, 75);
		heap.insert(55, 55);
		heap.insert(34, 34);
		heap.insert(28, 28);
		heap.insert(99, 99);
		heap.insert(34, 34);

		
		
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
	}

}
