package com.HL.LinkedList;
import java.util.NoSuchElementException;

import com.HL.Iterator.SLLIterator;

import com.HL.Iterator.Iterator;
public class SinglyLinkedList<E> {
	@SuppressWarnings("hiding")
	
	public class Node<E>{
		private Node next;
		private E element;
		public Node(E e, Node next) {
			this.element = e;
			this.next = next;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> i) {
			this.next = i;
		}
		
		public E getElement() {
			return element;
		}
	}
	
	private int size;
	private Node head;
	
	public SinglyLinkedList() {
		size = 0;
		head = null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean contains(E e) {
		for(int i = 0; i < size; i++) {
			if(get(i).getElement() == e) return true;
		}
		return false;
	}
	
	public int find(E e) {
		for(int i = 0; i < size; i++) {
			if(get(i).getElement() == e) return i;
		}
		return -1;
	}
	
	public E getFirst() {
		return (E) head.getElement();
	}
	
	public E getLast() {
		if(isEmpty()) return null;
		return (E)get(size-1).getElement();
	}
	
	public void addFirst(E e) {
		Node aux = new Node(e, null);
		if(isEmpty()) head = aux;
		else {
			aux.setNext(head);
			head = aux;
		}
		size++;
	}
	
	public Node<E> get(int index){
		if(index < 0 || index >= size) return null;
		Node<E> curr = head;
		for(int i = 0; i < index; i++) curr = curr.getNext();
		return curr;
	}
	
	public void addLast(E e) {
		Node aux = new Node(e, null);
		if(isEmpty()) head = aux;
		else {
			Node curr = get(size - 1);
			curr.setNext(aux);
		}
		size++;
	}
	
	public E removeFirst() {
		if(isEmpty()) return null;
		else {
			E temp = (E) head.getElement();
			if(size == 1) {
				head = null;
				size--;
				return temp;
			}else {
				Node aux = head.getNext();
				head.setNext(null);
				head = aux;
				size--;
				return temp;
			}
		}
	}
	
	public E removeLast() {
		if(isEmpty()) return null;
		Node tail = get(size - 1);
		E temp = (E)tail.getElement();
		if(size == 1) {
			tail = null;
			size--;
		}else {
			Node prev = get(size - 2);
			prev.setNext(null);
			tail = prev;
			size--;
		}
		return temp;
	}
	
	public E remove(int index) throws IllegalArgumentException {
		if(index < 0 || index >= size) throw new IllegalArgumentException("nothing to remove");
		else if(index == 0) removeFirst();
		else if(index == size - 1) removeLast();
		else{
			E temp = get(index).getElement();
			Node prev = get(index - 1);
			Node next = get(index + 1);
			prev.setNext(next);
			size--;
			return temp;
		}
		return null;
	}

	public Iterator<E> myIterator() {
		return new SLLIterator<E>(this);
	}
}
