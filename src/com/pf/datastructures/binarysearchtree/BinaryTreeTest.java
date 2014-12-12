package com.pf.datastructures.binarysearchtree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTree<Integer, Integer> tree = new BinaryTree<>();
		tree.insert(10, 10);
		tree.insert(5, 5);
		tree.insert(15, 15);
		tree.insert(3, 3);
		tree.insert(7, 7);
		tree.insert(12, 12);
		tree.insert(17, 17);
		
		tree.traverse();
		System.out.println("------------------");
		System.out.println(tree.delete(10));
		System.out.println("------------------");
		tree.traverse();
	}

}
