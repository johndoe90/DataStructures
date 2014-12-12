package com.pf.datastructures.arraylist;

import java.util.Iterator;


//instead of Element use Object
public class ArrayList<T> implements Iterable<T> {

	int elements;
	Element<T>[] data;
	
	public ArrayList() {
		elements = 0;
		data = new Element[5];
	}
	
	public void enhance() {
		System.out.println("Resize from " + data.length + " to " + 2 * data.length);
		
		Element<T>[] newData = new Element[data.length * 2];
		for ( int i = 0; i < data.length; i++ ) 
			newData[i] = data[i];
		
		data = newData;
	}
	
	public void add(T val) {
		Element newElement = new Element(val);
		
		if ( elements >= data.length ) 
			enhance();
		
		data[elements++] = newElement;		
	}
	
	public boolean delete(T val) {
		for ( int i = 0; i < elements; i++ ) {
			if ( data[i].data.equals(val) ) {
				for ( int j = i; j < elements - 1; j++ ) {
					data[j] = data[j+1];
				}
				
				elements--;
				
				return true;
			}
		}
		
		return false;
	}
	
	public int size() {
		return elements;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator<T>(this);
	}
}
