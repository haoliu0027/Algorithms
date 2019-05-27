package com.HL.LinkedList;

public class DoubleLinkedList<E> {
	@SuppressWarnings("hiding")
	private class Node<E>{
		private Node<E> next;
		private Node<E> prev;
		private E element;
		
		private Node (E e, Node<E> prev, Node<E> next){
			this.element = e;
			this.prev = prev;
			this.next = next;
		}
		
		private E getElement() {
			return element;
		}
		
		private Node<E> getNext(){
			return next;
		}
		
		private Node<E> getPrev(){
			return prev;
		}
		
		private void setNext(Node<E> aux) {
			this.next = aux;
		}
		
		private void setPrev(Node<E> aux) {
			this.prev = aux;
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public DoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E getFirst() {
		return head.getElement();
	}
	
	public E getLast() {
		return tail.getElement();
	}
	
	public boolean contains(E e) {
		for(int i = 0; i < size; i++) {
			if(get(i).getElement() == e) return true;
		}
		return false;
	}
	
	public int find(E e) {
		for(int i = 0; i < size; i++) {
			if(get(i).getElement() == e) return 1;
		}
		return -1;
	}
	
	public void addFirst(E e) {
		Node<E> aux = new Node<>(e, null, null);
		if(isEmpty()) head = tail = aux;
		else {
			aux.setNext(head);
			head.setPrev(aux);
			head = aux;
		}
		size++;
	}
	
	public void addLast(E e) {
		Node<E> aux = new Node<>(e, null, null);
		if(isEmpty()) head = tail = null;
		else {
			tail.setNext(aux);
			aux.setPrev(tail);
			tail = aux;
		}
		size++;
	}
	
	public Node<E> get(int index){
		if(index < 0|| index >= size)
			throw new IllegalArgumentException("Not in the range");
		if(index < (size/2)) {
			Node<E> curr = head;
			for(int i = 0; i < index; i++) curr = curr.getNext();
			return curr;
		}else {
			Node<E> curr = tail;
			for(int j = size - 1; j > index; j--) curr = curr.getPrev();
			return curr;
		}
		
	}
	
	public void add(int index, E e) {
		Node<E> aux = new Node<E>(e, null, null);
		if(index == 0) addFirst(e);
		else if(index == size) addLast(e);
		else {
			Node<E> preNode = get(index-1);
			Node<E> nextNode = get(index);
			preNode.setNext(aux);
			aux.setPrev(preNode);
			nextNode.setPrev(aux);
			aux.setNext(nextNode);
			size++;
		}
	}
	
	public E removeFirst() {
		if(isEmpty()) return null;
		else {
			E temp = head.getElement();
			if(size == 1) {
				head = tail = null;
			}else {
				Node<E> nextNode = head.getNext();
				nextNode.setPrev(null);
				head.setNext(null);
				head = nextNode;
			}
			size--;
			return temp;
		}
	}
	
	public E removeLast() {
		if(isEmpty()) return null;
		else {
			E temp = tail.getElement();
			if(size == 1) {
				head = tail = null;
			}else {
				Node<E> preNode = tail.getPrev();
				preNode.setNext(null);
				tail.setPrev(null);
				tail = preNode;
			}
			size--;
			return temp;
		}
	}
	
	public E remove(int index) {
		if(index < 0 || index >= size) return null;
		else if(index == 0) return removeFirst();
		else if(index == size - 1) return removeLast();
		else {
			Node<E> curr = get(index);
			E temp = curr.getElement();
			Node<E> prevNode = curr.getPrev();
			Node<E> nextNode = curr.getNext();
			prevNode.setNext(nextNode);
			nextNode.setPrev(prevNode);
			size--;
			return temp;
		}
	}
}
