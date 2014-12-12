package com.pf.datastructures.stack;

import com.pf.datastructures.linkedlist.Link;
import com.pf.datastructures.linkedlist.LinkedList;


public class StackTest {
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		
		System.out.println("Is empty: " + stack.isEmpty());
		System.out.println("Is full: " + stack.isFull());
		
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		System.out.println("Is empty: " + stack.isEmpty());
		System.out.println("Is Full: " + stack.isFull());
		
		System.out.println("Peek: " + stack.peek());
		System.out.println("Peek again: " + stack.peek());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println("Is empty: " + stack.isEmpty());
		System.out.println("Is Full: " + stack.isFull());
	}
}
