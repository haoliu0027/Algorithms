package com.HL.Queue;
import com.HL.Array.*;
public class ArrayQueue<E> implements Queue<E> {
	
	Array<E> array;
	
	public ArrayQueue(int capacity) {
		array = new Array<>(capacity);
	}
	
	public ArrayQueue() {
		this(10);
	}

	@Override
	public void offer(E e) {
		array.addLast(e);
	}

	@Override
	public E poll() {
		return array.removeFirst();
	}

	@Override
	public E peek() {
		return array.getFirst();
	}

	@Override
	public int size() {
		return array.size();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Queue: [");
		for(int i = 0; i < size(); i++) {
			sb.append(array.get(i));
			if(i != size() - 1) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
}
