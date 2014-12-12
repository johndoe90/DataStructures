package com.pf.datastructures.hashtable;

public class HashTable<S, T> {
	
	private final int size;
	private final Entry<S, T>[] data;
	
	public HashTable(int size) {
		this.size = nextPrime(size * 2);		
		data = new Entry[this.size];
	}
	
	private int nextPrime(int n) {
		while ( !isPrime(n) ) { n++; }
		return n;
	}
	
	private boolean isPrime(int n) {
		double sqrt = Math.ceil(Math.sqrt(n));
		for ( int i = 2; i < sqrt; i++ ) {
			if ( n % i == 0 ) {
				return false;
			}
		}
		
		return true;
	}
	
	private int hash(S key) {
		return key.hashCode() % size;
	}
	
	
	public void insert(S key, T value) {
		int hash = hash(key);
		while ( data[hash] != null && data[hash].deleted == false ) {
			//linear probing
			hash += 1;
			hash %= size;
			
			//quadratic probing
			//hash += n * n; n-> nth step
			//hash %= size;
			
			//double hash
			//hash += 2nd hash;
			//hash %= size;
		}
		
		System.out.println(hash);
		data[hash] = new Entry<S, T>(key, value);
	}
	
	public T find(S key) {
		int hash = hash(key);
		while ( data[hash] != null ) {
			if ( data[hash].key.equals(key) && data[hash].deleted == false ) {
				return data[hash].data;
			}
			
			hash += 1;
			hash %= size;
		}
		
		return null;
	}
	
	public boolean delete(S key) {
		int hash = hash(key);
		while ( data[hash] != null ) {
			if ( data[hash].key.equals(key) ) {
				data[hash].deleted = true;
				return true;
			}
			
			hash += 1;
			hash %= size;
		}
		
		return false;
	}
}
