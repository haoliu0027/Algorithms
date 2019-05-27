package com.HL.Map.Tree.copy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
	private class Node<E>{
		public E e;
		public Node<E> left;
		private Node<E> right;
		public Node(E e) {
			this.e = e;
			this.left = left;
			this.right = right;
		}
	}
	
	private Node<E> root;
	private int size;
	
	public BST() {
		root = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void add(E e) {
		root = add(root, e);
	}
	
	private Node<E> add(Node<E> node, E e) {
		if(node == null) {
			size++;
			return new Node(e);
		}
		if(e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		}else if(e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		}
		return node;
		
	}
	public boolean contains(E e) {
		return contains(root, e);
	}
	
	public boolean contains(Node<E> node, E e) {
		if(node == null) return false;
		if(e.equals(node.e)) return true;
		else if(e.compareTo(node.e) < 0) return contains(node.left, e);
		else return contains(node.right, e);
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node<E> node) {
		if(node == null) return;
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void preOrderNR() {
		Stack<Node<E>> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node<E> curr = stack.pop();
			System.out.println(curr.e);
			if(curr.right != null) stack.push(curr.right);
			if(curr.left != null) stack.push(curr.left);
		}
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(Node<E> node) {  //sort
		if(node == null) return;
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(Node<E> node) {
		if(node == null) return;
		inOrder(node.left);
		inOrder(node.right);
		System.out.println(node.e);
	}
	
	public void breathFirstOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			System.out.println(curr.e);
			if(curr.left != null) queue.add(curr.left);
			if(curr.right != null) queue.add(curr.right);
		}
	}
	
	public E min() {
		if(size == 0) throw new IllegalArgumentException("BST is empty");
		return (E) min(root).e;
	}
	
	private Node<E> min(Node<E> node) {
		if(node.left  == null) return node;
		return min(node.left);
	}
	
	public E removeMin() {
		E temp = min();
		root = removeMin(root);
		return temp;
	}
	
	private Node removeMin(Node node) {
		if(node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}
	
	public E max() {
		if(size == 0) throw new IllegalArgumentException("BST is empty");
		return (E) max(root).e;
	}
	
	private Node max(Node node) {
		if(node.right  == null) return node;
		return max(node.right);
	}
	
	public E removeMax() {
		if(isEmpty()) throw new IllegalArgumentException("BST is empty");
		Node max = max(root);
		removeMax(root);
		return (E) max.e;
	}
	
	private Node<E> removeMax(Node node) {
		if(node.right == null) {
			Node left = node.left;
			node.left = null;
			size--;
			return left;
		}
		node.right = removeMax(node.right);
		return node;
	}
	
	public void remove(E e) {
		if(isEmpty()) throw new IllegalArgumentException("BST is empty");
		else if(e.equals(max(root))) removeMax();
		else if(e.equals(min(root))) removeMin();
		else {
			remove(root, e);
		}
	}
	
	private Node<E> remove(Node<E> node, E e) {
		if(node == null) return null;
		if(e.compareTo(node.e) < 0) {
			node.left = remove(node.left, e);
			return node;
		}
		else if(e.compareTo(node.e) > 0) {
			node.right = remove(node.right, e);
			return node;
		}
		else{
			if(node.left == null && node.right == null) {
				size--;
				return null;
			}
			else if(node.left != null && node.right == null) {
				Node left = node.left;
				node.left = null;
				size--;
				return left;
			}else if(node.right != null && node.left == null) {
				Node right = node.right;
				node.right = null;
				size--;
				return right;
			}else {
				Node successor = min(node.right);
				successor.right = removeMin(node.right);
				successor.left = node.left;
				node.left = null;
				node.right = null;
				return successor;
			}
		}
	}
}
