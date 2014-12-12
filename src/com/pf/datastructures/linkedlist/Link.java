package com.pf.datastructures.linkedlist;

public class Link<T> {
	T data;
	Link<T> next;
	Link<T> previous;
	
	public Link(T data) {
		this.data = data;
	}
}
