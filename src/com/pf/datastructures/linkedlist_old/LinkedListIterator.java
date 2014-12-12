package com.pf.datastructures.linkedlist_old;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {

	private Link<T> current;
	private final LinkedList<T> list;
	
	public LinkedListIterator(LinkedList<T> list) {
		this.list = list;
		this.current = list.firstLink;
	}
	
	@Override
	public boolean hasNext() {
		return (current != null);
	}

	@Override
	public T next() {
		T data = current.data();
		current = current.getNext();
		return data;
	}
}
