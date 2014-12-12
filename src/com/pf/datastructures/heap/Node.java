package com.pf.datastructures.heap;

public class Node<S extends Comparable<S>, T> {
	S key;
	T data;
	
	public Node(S key, T data) {
		this.key = key;
		this.data = data;
	}
}
