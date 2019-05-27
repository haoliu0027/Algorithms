package com.HL.Set;
import com.HL.LinkedList.*;
public class DLLSet<E> implements Set<E>{

	private DoubleLinkedList<E> list;
	
	public DLLSet() {
		this.list = new DoubleLinkedList<>();
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
	public void add(E e) {
		if(!list.contains(e))
			list.addFirst(e);
	}

	@Override
	public void remove(E e) {
		int index = list.find(e);
		list.remove(index);
	}

	@Override
	public boolean contains(E e) {
		return list.contains(e);
	}
	
}
