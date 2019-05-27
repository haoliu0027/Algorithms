package com.HL.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AVL<E extends Comparable<E>> {
	private class Node<E>{
		public E e;
		public Node<E> left;
		private Node<E> right;
		private int height;
		public Node(E e) {
			this.e = e;
			this.left = left;
			this.right = right;
			this.height = 1;
		}
	}
	
	private Node<E> root;
	private int size;
	
	public AVL() {
		root = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private int getHeight(Node node) {
		if(node == null) return 0;
		return node.height;
	}
	
	private int getBalancedFactor(Node node) {
		if(node == null) return 0;
		return getHeight(node.left) - getHeight(node.right);
	}
	
	public boolean isBST() {
		ArrayList<E> list = new ArrayList<>();
		inOrder(root, list);
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i).compareTo(list.get(i-1)) < 0) return false;
		}
		return true;
	}
	
	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	private boolean isBalanced(Node node) {
		if(node == null) return true;
		if(getBalancedFactor(node) > 1) return false;
		return isBalanced(node.left) && isBalanced(node.right);
	}
	
	private void inOrder(Node<E> node, ArrayList<E> list) {
		if(root == null) return;
		inOrder(node.left, list);
		list.add(node.e);
		inOrder(node.right, list);
	}
	
	public void add(E e) {
		root = add(root, e);
	}
	
	private Node rightRotate(Node y) {
		Node x = y.left;
		Node T3 = x.right;
		
		x.right = y;
		y.left = T3;
		
		y.height = Math.max(getHeight(y.left) , getHeight(y.right));
		x.height = Math.max(getHeight(x.left), getHeight(x.right));
		return x;
	}
	
	private Node leftRotate(Node y) {
		Node x = y.right;
		Node T2 = x.left;
		
		x.left = y;
		y.right = T2;
		
		y.height = Math.max(getHeight(y.left) , getHeight(y.right));
		x.height = Math.max(getHeight(x.left), getHeight(x.right));
		return x;
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
		
		node.height = 1 + (int)Math.max(getHeight(node.left), getHeight(node.right));
		int balancedfactor = getBalancedFactor(node);
		if(balancedfactor > 1 && getBalancedFactor(node.left) >= 0) 
			return rightRotate(node);
		if(balancedfactor < -1 && getBalancedFactor(node.right) <= 0) {
				return leftRotate(node);
		}
		if(balancedfactor > 1 && getBalancedFactor(node.left) < 0) {
			node.left = leftRotate(node);
			return rightRotate(node);
		}
		if(balancedfactor < -1 && getBalancedFactor(node.right) > 0) {
			node.right = rightRotate(node);
			return leftRotate(node);
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
		Node retNode;
		if(e.compareTo(node.e) < 0) {
			node.left = remove(node.left, e);
			retNode = node;
		}
		else if(e.compareTo(node.e) > 0) {
			node.right = remove(node.right, e);
			retNode = node;
		}
		else{
			if(node.left == null && node.right == null) {
				size--;
				retNode = null;
			}
			else if(node.left != null && node.right == null) {
				Node left = node.left;
				node.left = null;
				size--;
				retNode = left;
			}else if(node.right != null && node.left == null) {
				Node right = node.right;
				node.right = null;
				size--;
				retNode = right;
			}else {
				Node successor = min(node.right);
				successor.right = remove(node.right, (E) successor.e);
				successor.left = node.left;
				node.left = null;
				node.right = null;
				retNode = successor;
			}
		}
		
		if(retNode == null) return null;
		
		retNode.height = 1 + (int)Math.max(getHeight(retNode.left), getHeight(retNode.right));
		int balancedfactor = getBalancedFactor(retNode);
		if(balancedfactor > 1 && getBalancedFactor(retNode.left) >= 0) 
			return rightRotate(retNode);
		if(balancedfactor < -1 && getBalancedFactor(retNode.right) <= 0) {
				return leftRotate(retNode);
		}
		if(balancedfactor > 1 && getBalancedFactor(retNode.left) < 0) {
			retNode.left = leftRotate(retNode);
			return rightRotate(retNode);
		}
		if(balancedfactor < -1 && getBalancedFactor(retNode.right) > 0) {
			retNode.right = rightRotate(retNode);
			return leftRotate(retNode);
		}
		return retNode;
	}
}
