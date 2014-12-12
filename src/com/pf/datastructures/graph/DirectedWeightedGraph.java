package com.pf.datastructures.graph;

import java.util.LinkedList;
import java.util.Stack;

public class DirectedWeightedGraph<T> {

	private int last = -1;
	private int[][] adjMatrix;
	private Vertex<T>[] vertices;
	
	public DirectedWeightedGraph(int maxVertices) {
		vertices = new Vertex[maxVertices];
		adjMatrix = new int[maxVertices][maxVertices];
	}
	
	public boolean isFull() {
		return last == vertices.length - 1;
	}
	
	public boolean isEmpty() {
		return last == -1;
	}
	
	public void addVertex(T data) {
		if ( isFull() ){
			System.out.println("Graph is full");
			return;
		}
		
		vertices[++last] = new Vertex<>(data);
	}
	
	public void addEdge(int from, int to) {
		addEdge(from, to, 1);
	}
	
	public void addEdge(int from, int to, int weight) {
		if ( from == to || from < 0 || from > last || to < 0 || to > last || weight < 0 ) {
			System.out.println("Wrong input");
			return;
		}
		
		adjMatrix[from][to] = weight;
	}
	
	public void printMatrix() {
		for ( int i = 0; i < vertices.length; i++ ) {
			for ( int j = 0; j < vertices.length; j++ ) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			
			System.out.println("");
		}
		
		System.out.println("----------------------------------");
	}
	
	public void remove(int v) {
		if ( v < 0 || v > last ) {
			System.out.println("Wrong input");
			return;
		}
		//something wrong
		for ( int i = 0; i < last; i++ ) {
			for ( int j = 0; j < last; j++ ) {
				if ( i < v && j >= v ) {
					adjMatrix[i][j] = adjMatrix[i][j+1];
				} else if ( i >= v && j >= v ) {
					adjMatrix[i][j] = adjMatrix[i+1][j+1];
				} else if ( i >= v && j < v ) {
					adjMatrix[i][j] = adjMatrix[i+1][j];
				}
			}
		}
		
		for ( int i = 0; i <= last; i++ ) {
			adjMatrix[i][last] = 0;
			adjMatrix[last][i] = 0;
		}
		
		for ( int i = v; i < last; i++ ) {
			vertices[i] = vertices[i+1];
		}
		
		last--;
	}
	
	private int getAdjUnvisitedVertex(int j) {
		for ( int i = 0; i <= last; i++ ) {
			if ( adjMatrix[j][i] != 0 && !vertices[i].visited ) {
				return i;
			}
		}
		
		return -1;
	}
	
	private void displayVertex(int i) {
		System.out.println(vertices[i].data.toString());
	}
	
	private void unvisitVertices(){
		for ( int i = 0; i <= last; i++ ) {
			vertices[i].visited = false;
		}
	}
	
	public void depthFirstTraversal(int from) {
		if ( from < 0 || from > last ) {
			System.out.println("Wrong input");
			return;
		}
		
		int v;
		displayVertex(from);
		vertices[from].visited = true;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(from);
		
		while ( !stack.isEmpty() ) {
			v = getAdjUnvisitedVertex(stack.peek());
			if ( v == -1 ) {
				stack.pop();
			} else {
				stack.push(v);
				displayVertex(v);
				vertices[v].visited = true;
			}
		}
		
		unvisitVertices();
	}
	
	public void breadthFirstTraversal(int from) {
		if ( from < 0 || from > last ) {
			System.out.println("Wrong input");
			return;
		}
		
		int v1, v2;
		displayVertex(from);
		vertices[from].visited = true;
		
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(from);
		
		while ( !queue.isEmpty() ) {
			v1 = queue.remove();
			
			while ( (v2 = getAdjUnvisitedVertex(v1)) != -1 ) {
				queue.add(v2);
				vertices[v2].visited = true;
				displayVertex(v2);
			}
		}
		
		unvisitVertices();
	}
	
	public void minimumNonWeightedSpanningTree(int from) {
		if ( from < 0 || from > last ) {
			System.out.println("Wrong input");
			return;
		}
		
		int v1, v2;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(from);
		
		vertices[from].visited = true;
		
		while ( !stack.isEmpty() ) {
			v1 = stack.peek();
			v2 = getAdjUnvisitedVertex(v1);
			
			
			if ( v2 == -1 ) {
				stack.pop();
			} else {
				System.out.print(vertices[v1].data.toString());
				System.out.println(vertices[v2].data.toString());
				
				stack.push(v2);
				vertices[v2].visited = true;
			}
		}
		
		unvisitVertices();
	}
	
	public int noSuccessor() {
		boolean hasIncoming;
		for ( int i = 0; i <= last; i++ ) {
			hasIncoming = false;
			for ( int j = 0; j <= last; j++ ) {
				if ( adjMatrix[j][i] != 0 ) {
					hasIncoming = true;
					break;
				}
			}
			
			if ( !hasIncoming ) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void topologicalSort() {
		int v;
		for ( int i = last; i >= 0; i-- ) {
			v = noSuccessor();
			if ( v == -1 ) {
				System.out.println("This graph is not acyclic");
				return;
			} else {
				displayVertex(v);
				remove(v);
			}
		}
	}
}
