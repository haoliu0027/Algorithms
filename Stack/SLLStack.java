package com.HL.Stack;
import com.HL.LinkedList.SinglyLinkedList;;
public class SLLStack<E> implements Stack<E> {
	SinglyLinkedList<E> list;
	
	public SLLStack(){
		list = new SinglyLinkedList<>();
	}
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(E e) {
		list.addLast(e);
	}

	@Override
	public E pop() {
		return list.removeLast();
	}

	@Override
	public E peek() {
		return list.getLast();
	}
	
}
