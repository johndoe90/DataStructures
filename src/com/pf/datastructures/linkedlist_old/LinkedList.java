package com.pf.datastructures.linkedlist_old;

import java.util.Iterator;

public class LinkedList<T> {
	
	public Link<T> firstLink;
	
	public LinkedList() {
		firstLink = null;
	}
	
	public void add(T element) {
		Link<T> newLink = new Link<T>(element);
		newLink.setNext(firstLink);
		firstLink = newLink;
	}
	
	public Iterator<T> iterator() {
		return new LinkedListIterator<T>(this);
	}
	
	public Integer indexOf(T element) {
		Integer index = 0;
		Link<T> link = firstLink;
		while ( link != null ) {
			if ( link.data() == element ) {
				return index;
			}
			
			index += 1;
			link = link.getNext();
		}
		
		return -1;
	}
	
	public boolean isEmpty() {
		return firstLink == null ? true : false;
	}
	
	public T get(Integer index)  {
		Link<T> link = firstLink;
		for ( int i = 0; i < index; i++ ) {
			if ( link == null ) {
				
			}
			
			link = link.getNext();
		}
		
		return link.data();
	}
	
	public T getFirst() {
		return firstLink.data();
	}
}
