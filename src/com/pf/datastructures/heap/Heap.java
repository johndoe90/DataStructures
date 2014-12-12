package com.pf.datastructures.heap;

public class Heap<S extends Comparable<S>, T> {
	
	Node<S, T>[] data;
	private int currentSize = 0;
	
	public Heap(int size) {
		data = new Node[size];
	}
	
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	public boolean isFull() {
		return currentSize == data.length;
	}
	
	public void insert(S key, T value) {
		if ( isFull() ) return;
		
		Node<S, T> newNode = new Node<S, T>(key, value);
		data[currentSize] = newNode;
		trickleUp(currentSize);
		currentSize++;
	}
	
	public T delete() {
		if ( isEmpty() ) return null;
		
		Node<S, T> temp = data[0];
		data[0] = data[currentSize - 1];
		trickleDown(0);
		currentSize--;
		
		return temp.data;
	}
	
	public void change(S key, T newValue) {
		
	}
	
	private void trickleDown(int index) {
		int larger;
		Node<S, T> top = data[index];
		
		while ( index < currentSize / 2 ) {
			int left = 2 * index + 1;
			int right = 2 * index + 2;
			
			if ( right < currentSize && data[left].key.compareTo(data[right].key) < 0 ) 
				larger = right;
			else
				larger = left;
			
			if ( top.key.compareTo(data[larger].key) > 0 ) {
				break;
			}
			
			data[index] = data[larger];
			index = larger;
		}
		
		data[index] = top;
	}
	
	private void swap(int indexA, int indexB) {
		Node<S, T> temp = data[indexA];
		data[indexA] = data[indexB];
		data[indexB] = temp;
	}
	
	private void trickleUp(int index) {
		int parent;
		Node<S, T> temp = data[index];
		
		while ( index >= 1 ) {
			parent = (index - 1) / 2;
			
			if ( data[parent].key.compareTo(temp.key) < 0 ) {
				data[index] = data[parent];
				index = parent;
			} else {
				break;
			}
		}
		
		data[index] = temp; 		
	}
}
