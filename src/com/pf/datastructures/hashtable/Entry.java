package com.pf.datastructures.hashtable;

public class Entry<S, T> {
	S key;
	T data;
	boolean deleted = false;
	
	public Entry(S key, T data) {
		this.key = key;
		this.data = data;
	}
}
