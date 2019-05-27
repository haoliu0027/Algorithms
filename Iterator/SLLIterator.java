package com.HL.Iterator;

import java.util.NoSuchElementException;

import com.HL.LinkedList.SinglyLinkedList;

public class SLLIterator<E> implements Iterator<E> {
	
	private int j;
	private boolean removable;
	private SinglyLinkedList<E> list;
	
	public SLLIterator(SinglyLinkedList<E> list) {
		j = 0;
		removable = false;
		this.list = list;
	}
	
	@Override
	public boolean hasNext() {
		return j < list.size();
	}

	@Override
	public E next() throws NoSuchElementException {
		if(j == list.size()) throw new NoSuchElementException("no next element");
		removable = true;
		return (E) list.get(j++).getElement();
	}
	
	@Override
	public void remove() throws IllegalArgumentException{
		if(!removable) throw new IllegalArgumentException(" nothing to remove");
		list.remove(j-1);
		j--;
		removable = false;
	}

}
