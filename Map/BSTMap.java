package com.HL.Map;

import java.util.LinkedList;
import java.util.Queue;

public class BSTMap <K extends Comparable<K>, V> implements Map<K, V> {
	
	public class Node<K, V>{
		public K key;
		public V value;
		public Node<K, V> left;
		public Node<K, V> right;
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	private int size;
	private Node<K, V> root;
	
	public BSTMap() {
		size = 0;
		root = null;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(K key) {
		if(getNode(root, key) != null) return true;
		else return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void put(K key, V value) {
		root = put(key, value, root);
	}
	
	public Node put(K key, V value, Node<K, V> node) {
		if(node == null) {
			size++;
			return new Node(key, value);
		}
		if(key.compareTo(node.key) < 0) {
			node.left = put(key, value, node.left);
		}else if (key.compareTo(node.key) > 0) {
			node.right = put(key, value, node.right);
		}else node.value = value;
		return node;
	}
	
	public Node<K, V> getNode(Node node, K key){
		if(node == null) return null;
		if(key.equals(node.key)) return node;
		if(key.compareTo((K) node.key) < 0) node.left = getNode(node.left, key);
		else if(key.compareTo((K) node.key) > 0) node.right = getNode(node.right, key);
		return node;
	}
	
	@Override
	public V remove(K key) {
		if(!contains(key)) return null;
		else {
			Node aux = getNode(root, key);
			root = remove(root, key);
			return (V) aux.value;
		}
	}
	
	public Node<K, V> remove(Node<K, V> node, K key){
		if(node == null) return null;
		if(key.compareTo(node.key) < 0){
			node.left = remove(node.left , key);
			return node;
		}else if(key.compareTo(node.key) > 0) {
			node.right = remove(node.right, key);
			return node;
		}else {
			if(node.left == null && node.right == null) {
				size--;
				return null;
			}else if(node.left != null && node.right == null) {
				Node aux = node.left;
				node.left = null;
				size--;
				return aux;
			}else if(node.left == null && node.right != null) {
				Node aux = node.right;
				node.right = null;
				size--;
				return aux;
			}else {
				Node nodeMin = Min(node.right);
				nodeMin.right = removeMin(node.right);
				nodeMin.left = node.left;
				node.left = null;
				node.right = null;
				size--;
				return nodeMin;
			}
		}
	}
	
	public Node Min(Node node) {
		if(node == null) return null;
		if(node.left == null) return node;
		return Min(node.left);
	}
	
	public Node removeMin(Node node) {
		if(node.left == null) {
			Node nodeR = node.right;
			node.right = null;
			size--;
			return nodeR;
		}
		node.left = removeMin(node.left);
		return node;
		
	}
	
	@Override
	public V get(K key) {
		return getNode(root, key).value;
	}

	@Override
	public void set(K key, V value) {
		Node<K, V> node = getNode(root, key);
		if(node == null) throw new IllegalArgumentException("not exist");
		node.value = value;
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node<K, V> root) {
		if(root == null) return;
		System.out.println("key : "+ root.key+ "value : "+ root.value);
		if(root.left != null) preOrder(root.left);
		if(root.right != null) preOrder(root.right);
	}
	
	public void BFS() {
		BFS(root);
	}
	
	private void BFS(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			Node aux = queue.poll();
			System.out.println("key :  "+aux.key+ "  value "+ aux.value);
			if(aux.left != null) queue.add(aux.left);
			if(aux.right != null) queue.add(aux.right);
		}
	}

}
