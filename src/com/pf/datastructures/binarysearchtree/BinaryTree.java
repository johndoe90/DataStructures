package com.pf.datastructures.binarysearchtree;

import java.util.Iterator;

public class BinaryTree<S extends Comparable<S>,T> {
	Node<S,T> rootNode;

	public void insert(S key, T val) {
		/*Node<S, T> newNode = new Node<S, T>(key, val);
		if ( rootNode == null ){
			rootNode = newNode;
			return;
		}
		
		Node<S, T> previous = null;
		Node<S, T> current = rootNode;
		while ( current != null ) {
			previous = current;
			if ( newNode.key.compareTo(current.key) < 0 ) {
				current = current.leftNode;
				if ( current == null ) {
					previous.leftNode = newNode;
				}
			} else {
				current = current.rightNode;
				if ( current == null ) {
					previous.rightNode = newNode;
				}
			}
		}*/
		
		Node<S, T> newNode = new Node<S, T>(key, val);
		if ( rootNode == null ){
			rootNode = newNode;
			return;
		}
		
		Node<S, T> current = rootNode;
		while ( true ) {
			if ( newNode.key.compareTo(current.key) < 0 ) {
				if ( current.leftNode != null ) {
					current = current.leftNode;
					continue;
				} else {
					current.leftNode = newNode;
					break;
				}
			} else {
				if ( current.rightNode != null ) {
					current = current.rightNode;
					continue;
				} else {
					current.rightNode = newNode;
					break;
				}
			}
		}
	}
	
	public T find(S key) {
		Node<S, T> current = rootNode;
		while ( current != null ) {
			if ( key.compareTo(current.key) == 0 ) {
				return current.data;
			} else if ( key.compareTo(current.key) < 0 ) {
				current = current.leftNode;
			} else {
				current = current.rightNode;
			}
		}
		
		return null;
	}
	
	private void rTraverse(Node<S, T> node) {
		if ( node != null ) {
			rTraverse(node.leftNode);
			System.out.println(node.data);
			rTraverse(node.rightNode);
		}
	}
	
	public void traverse() {
		rTraverse(rootNode);
	}
	
	public Iterator<T> getIterator() {
		return new InOrderBinaryTreeIterator<S, T>(this);
	}
	
	public boolean delete(S key) {
		Node<S, T> previous = null;
		Node<S, T> current = rootNode;
		
		//find the node
		while ( key.compareTo(current.key) != 0 ) {
			previous = current;
			if ( key.compareTo(current.key) < 0 ) {
				current = current.leftNode;
			} else {
				current = current.rightNode;
			}
			
			//node was not found
			if ( current == null ) {
				return false;
			}
		}
		
		if ( current.leftNode == null && current.rightNode == null ) {	//leaf node
			if ( current == rootNode ) {
				rootNode = null;
			}else if ( current == previous.leftNode ) {
				previous.leftNode = null;
			} else {
				previous.rightNode = null;
			}
		} else if ( current.leftNode == null && current.rightNode != null ) {	//only right child
			if ( current == rootNode ) {
				rootNode = current.rightNode;
			} else if ( current == previous.leftNode ) {
				previous.leftNode = current.rightNode;
			} else {
				previous.rightNode = current.rightNode;
			}
		} else if ( current.leftNode != null && current.rightNode == null ) {	// only left child
			if ( current == rootNode ) {
				rootNode = current.leftNode;
			} else if ( current == previous.leftNode ) {
				previous.leftNode = current.leftNode;
			} else {
				previous.rightNode = current.leftNode;
			}
		} else {	//both left and right child			
			Node<S, T> successor = getSuccessor(current);
			
			if ( current == rootNode ) {
				rootNode = successor;
			} else if ( current == previous.leftNode ) {
				previous.leftNode = successor;
			} else {
				previous.rightNode = successor;
			}
			
			successor.leftNode = current.leftNode;
		}
		
		return true;
	}
	
	private Node<S, T> getSuccessor(Node<S, T> toDelete) {
		Node<S, T> previous = toDelete;
		Node<S, T> current = toDelete.rightNode;
		
		while ( current.leftNode != null ) {
			previous = current;
			current = current.leftNode;
		}
		
		if ( current != toDelete.rightNode ) {
			previous.leftNode = current.rightNode;
			current.rightNode = toDelete.rightNode;
		}
		
		return current;
	}
}
