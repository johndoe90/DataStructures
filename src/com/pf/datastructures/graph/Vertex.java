package com.pf.datastructures.graph;

public class Vertex<S> {
	public S data;
	public boolean visited = false;
	
	public Vertex(S data) {
		this.data = data;
	}
}
