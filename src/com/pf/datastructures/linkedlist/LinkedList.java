package com.pf.datastructures.linkedlist;

import java.util.Iterator;

public class LinkedList<T> {
	Link<T> last;
	Link<T> first;
	
	public static final String FORWARD = "FORWARD";
	public static final String BACKWARD = "BACKWARD";
	
	public LinkedList() {
		
	}
		
	public boolean isEmpty() {
		return first == null && last == null;
	}
	
	public void insertFirst(T t) {
		Link<T> newLink = new Link<T>(t);
		newLink.next = first;

		if ( isEmpty() ) {
			last = newLink;
		} else {
			first.previous = newLink;
		}
		
		first = newLink;
	}
	
	public void insertLast(T t) {
		Link<T> newLink = new Link<T>(t);
		newLink.previous = last;
		
		if ( isEmpty() ) { 
			first = newLink; 
		} else {
			last.next = newLink;
		}
		
		last = newLink;
	}
	
	public void insertAfter(int index, T t) {
		Link<T> current = first;
		Link<T> newLink = new Link<T>(t);
		
		for ( ;index != 0; index-- ) {
			current = current.next;
		}
		
		if ( current.next != null ) {
			current.next.previous = newLink;
		}
		
		
		
		newLink.next = current.next;
		newLink.previous = current;
		
		current.next = newLink;
	}
	
	public T remove(T t) {
		System.out.println("inhere");
		return remove(indexOf(t));
	}
	
	public T remove(int index) {
		Link<T> current = first;
		for ( ;index != 0; index-- ) {
			current = current.next;
		}
		
		/*if ( current == first ) {
			
		}*/
		
		
		if ( current.previous == null && current.next != null) {
			//delete the first element
			current.next.previous = null;
			first = current.next;
		} else if (current.next == null && current.previous != null) {
			//delete the last
			current.previous.next = null;
			last = current.previous;
		} else if ( current.next == null && current.previous == null){
			//only one element in the list
			first = null;
			last = null;
		} else {
			//multiple elements in the list + delete one from the middle
			current.previous.next = current.next;
			current.next.previous = current.previous;
		}
		
		return current.data;
	}
	
	public T removeFirst() {
		Link<T> result = first;
		if ( first.next == null ) {
			last = null;
		} else {
			first.next.previous = null;
		}
		
		first = first.next;
		return result.data;
	}
	
	public T removeLast() {
		Link<T> result = last;
		if ( last.previous == null ) {
			first = null;
		} else {
			last.previous.next = null;
		}
		
		last = last.previous;
		return result.data;
	}
	
	public int indexOf(T t) {
		int index = 0;
		Iterator<T> it = getIterator();
		while(it.hasNext()) {
			if ( it.next().equals(t) ) {
				return index;
			}
			
			index++;
		}
		
		return -1;
	}
	
	public Iterator<T> getIterator() {
		return getIterator(FORWARD);
	}
	
	public Iterator<T> getIterator(String order) {
		switch (order) {
			case FORWARD:
				return new LinkedListForwardIterator<T>(this);
			case BACKWARD:
				return new LinkedListBackwardIterator<T>(this);
			default:
				throw new RuntimeException("Unknown iterator");
		}
	}

	public void display() {
		int index = 0;
		Iterator<T> it = getIterator();
		while( it.hasNext() ) {
			System.out.println("Index: " + index++ + " / " + it.next());
		}
		
		System.out.println("----------------------------");
	}
}