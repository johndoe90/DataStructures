package com.pf.datastructures.binarysearchtree;

import java.util.Iterator;
import java.util.TreeMap;

public class InOrderBinaryTreeIterator<S extends Comparable<S>, T> implements Iterator<T> {

	private Node<S, T> current;
	private Node<S, T> previous;
	private final BinaryTree<S,T> tree;
	
	public InOrderBinaryTreeIterator(BinaryTree<S, T> tree) {
		this.tree = tree;
		
		previous = null;
		current = tree.rootNode;
		while ( current.leftNode != null ) {
			previous = current;
			current = current.leftNode;
		}
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public T next() {
		if ( current.leftNode != null ) {
			current = current.leftNode;
			//return 
		}
		
		return null;
	}
}
