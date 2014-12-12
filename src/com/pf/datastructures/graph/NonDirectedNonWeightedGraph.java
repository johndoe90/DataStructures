package com.pf.datastructures.graph;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class NonDirectedNonWeightedGraph<S> implements Graph<S> {
	private int maxSize;
	private int currentSize;
	private int[][] adjMatrix;
	private Vertex<S>[] vertexList;
	
	public NonDirectedNonWeightedGraph(int size) {
		maxSize = size;
		currentSize = 0;
		vertexList = new Vertex[maxSize];
		adjMatrix = new int[maxSize][maxSize];
	}
	
	@Override
	public void addVertex(S data) {
		if ( isFull() ) return;
		
		Vertex<S> newVertex = new Vertex<>(data);
		vertexList[currentSize++] = newVertex;
	}

	@Override
	public void addEdge(int start, int end) {
		if ( start < 0 || end >= maxSize ) return;
		
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}

	@Override
	public boolean isFull() {
		return maxSize == currentSize;
	}

	@Override
	public void depthFirstTraversal() {
		if ( isEmpty() ) return;
		
		Stack<Integer> stack = new Stack<>();
		
		System.out.println("Visited Vertex: " + vertexList[0].data.toString());
		vertexList[0].visited = true;
		stack.push(0);
		
		while ( !stack.isEmpty() ) {
			int v = getAdjUnvisitedVertex(stack.peek());
			if ( v == -1 ) {
				stack.pop();
			} else {
				stack.push(v);
				vertexList[v].visited = true;
				System.out.println("Visited Vertex: " + vertexList[v].data.toString());
			}
		}
		
		for ( int i = 0; i < currentSize; i++ ) {
			vertexList[i].visited = false;
		}
	}

	@Override
	public void breadthFirstTraversal() {
		if ( isEmpty() ) return;

		int v2;
		Queue<Integer> queue = new ArrayBlockingQueue<>(currentSize);
		queue.add(0);
		vertexList[0].visited = true;
		System.out.println("Visited Vertex: " + vertexList[0].data.toString());
		
		
		while ( !queue.isEmpty() ) {
			int v1 = queue.poll();
			
			while ( (v2 = getAdjUnvisitedVertex(v1)) != -1 ) {
				queue.add(v2);
				vertexList[v2].visited = true;
				System.out.println("Visited Vertex: " + vertexList[v2].data.toString());
			}
		}
		
		for ( int i = 0; i < currentSize; i++ ) {
			vertexList[i].visited = false;
		}
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	private int getAdjUnvisitedVertex(int v) {
		for ( int i = 0; i < currentSize; i++ ) {
			if ( adjMatrix[v][i] == 1 && !vertexList[i].visited ) {
				return i;
			}
		}
		
		return -1;
	}

	@Override
	public void minimumSpanningTree() {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		vertexList[0].visited = true;
		
		while ( !stack.isEmpty() ) {
			int current = stack.peek();
			int v = getAdjUnvisitedVertex(current);
			
			if ( v == -1 ) {
				stack.pop();
			} else {
				System.out.println(vertexList[current].data.toString());
				System.out.println(vertexList[v].data.toString());
				
				stack.push(v);
				vertexList[v].visited = true;
			}
		}
		
		for ( int i = 0; i < currentSize; i++ ) {
			vertexList[i].visited = false;
		}
	}
}
