package com.pf.datastructures.graph;

public class GraphTest {

	public static void main(String[] args) {
		//Graph<String> graph = new NonDirectedNonWeightedGraph<>(20);
		DirectedWeightedGraph<String> graph = new DirectedWeightedGraph<String>(10);
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		graph.addVertex("I");
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		
		graph.addEdge(1, 5);		
		graph.addEdge(5, 7);	
		
		graph.addEdge(3, 6);
		graph.addEdge(6, 8);
		

		
		//graph.depthFirstTraversal(0);
		//graph.remove(1);
		//graph.breadthFirstTraversal(0);
		
		//graph.minimumNonWeightedSpanningTree(1);
		graph.remove(1);
		graph.depthFirstTraversal(0);
		
		graph.topologicalSort();
	}

}
