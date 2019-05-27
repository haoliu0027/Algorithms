package com.HL.Set;

public interface Set<E> {
	int size();
	boolean isEmpty();
	void add(E e);
	void remove(E e);
	boolean contains(E e);
}
