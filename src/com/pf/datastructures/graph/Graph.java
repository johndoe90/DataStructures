package com.pf.datastructures.graph;

public interface Graph<S> {
	public boolean isFull();
	public boolean isEmpty();
	
	public void addVertex(S data);
	public void depthFirstTraversal();
	public void breadthFirstTraversal();
	public void addEdge(int start, int end);
	
	public void minimumSpanningTree();
}
