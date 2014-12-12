package com.pf.datastructures.binarysearchtree;

public class Node<S extends Comparable<?>, T> {
	S key;
	T data;
	Node<S,T> leftNode;
	Node<S,T> rightNode;
	
	public Node(S key, T data) {
		this.key = key;
		this.data = data;
	}
}
