package com.pf.datastructures.linkedlist_old;

public class Link<T>  {

	private T data;
	private Link<T> next;
	
	public Link(T data) {
		this.data = data;
	}
	
	public T data() {
		return data;
	}
	
	public Link<T> getNext() {
		return next;
	}
	
	public void setNext(Link<T> next) {
		this.next = next;
	}
}
