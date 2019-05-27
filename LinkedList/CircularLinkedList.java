package com.HL.LinkedList;

public class CircularLinkedList<E> {
	public class Node<E>{
		public E element;
		private Node next;
		public Node(E e, Node next) {
			this.element = e;
			this.next = next;
		}
		
		public Node<E> getNext(){
			return next;
		}
		
		public void setNext(Node aux) {
			this.next = aux;
		}
		
		public E getElement() {
			return element;
		}
	}
	
	private Node tail;
	private int size;
	
	public CircularLinkedList() {
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
		return (E) tail.getNext().getElement();
	}
	
	public E getLast() {
		return (E)tail.getElement();
	}
	
	public Node<E> get(int index){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Not in the range");
		Node curr = tail.getNext();
		for(int i = 0; i < index; i++) {
			curr = curr.getNext();
		}
		return curr;
	}
	
	public boolean contains(E e) {
		for(int i = 0; i < size; i++)
			if(get(i).getElement() == e) return true;
		return false;
	}
	
	public int find(E e) {
		for(int i = 0; i < size; i++)
			if(get(i).getElement() == e) return 1;
		return -1;
	}
	
	public void addFirst(E e) {
		Node aux = new Node(e, null);
		if(isEmpty()) {
			tail = aux;
			tail.setNext(tail);
		}else {
			Node head = tail.getNext();
			aux.setNext(head);
			tail.setNext(aux);
		}
		size++;
	}
	
	public void addLast(E e) {
		Node aux = new Node(e, null);
		if(isEmpty()) {
			tail = aux;
			tail.setNext(tail);
		}else {
			Node head = tail.getNext();
			aux.setNext(head);
			tail.setNext(aux);
			tail = aux;
		}
		size++;
	}
	
	public E removeFirst() {
		if(isEmpty()) return null;
		E temp = (E)tail.getNext().element;
		if(size == 1) 
			tail = null;
		else {
			Node next = tail.getNext().getNext();
			tail.setNext(next);
		}
		size--;
		return temp;
	}
	
	public E removeLast() {
		if(isEmpty()) return null;
		E temp = (E)tail.element;
		if(size == 1) tail = null;
		else {
			Node prev = get(size - 2);
			Node head = tail.getNext();
			prev.setNext(head);
			tail = prev;
		}
		size--;
		return temp;
	}
	
	public void rotate() {
		tail = tail.getNext();
	}
}
