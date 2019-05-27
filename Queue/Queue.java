package com.HL.Queue;

public interface Queue<E> {
	
	void offer(E e);
	
	E poll();
	
	E peek();
	
	int size();
	
	boolean isEmpty();
	
	String toString();
}
