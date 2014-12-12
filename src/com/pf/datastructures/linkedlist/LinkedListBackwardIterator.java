package com.pf.datastructures.linkedlist;

import java.util.Iterator;

public class LinkedListBackwardIterator<T> implements Iterator<T> {
	
	Link<T> current;
	final LinkedList<T> list;
	
	public LinkedListBackwardIterator(LinkedList<T> list) {
		this.list = list;
		this.current = list.last;
	}
	
	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		Link<T> result = current;
		current = current.previous;
		return result.data;
	}
}
