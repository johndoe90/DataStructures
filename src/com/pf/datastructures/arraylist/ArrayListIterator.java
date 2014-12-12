package com.pf.datastructures.arraylist;

import java.util.Iterator;

import javax.swing.text.AttributeSet;

public class ArrayListIterator<T> implements Iterator<T> {

	private int pos;
	private final ArrayList<T> list;
	
	public ArrayListIterator(ArrayList<T> list) {
		this.pos = 0;
		this.list = list;
	}
	
	@Override
	public boolean hasNext() {
		return pos < list.elements;
	}

	@Override
	public T next() {
		return list.data[pos++].data;
	}
}
