package com.pf.datastructures.linkedlist;

import java.util.Iterator;

public class LinkedListForwardIterator<T> implements Iterator<T> {

	Link<T> current;
	final LinkedList<T> list;
	
	public LinkedListForwardIterator(LinkedList<T> list) {
		this.list = list;
		this.current = list.first;
	}
	
	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		Link<T> result = current;
		current = current.next;
		return result.data;
	}

}
