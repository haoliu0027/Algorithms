package com.HL.Queue;
import com.HL.LinkedList.*;
public class CircularCLLQueue<E> implements Queue<E> {
	CircularLinkedList<E> list;

	public CircularCLLQueue() {
		list = new CircularLinkedList<>();
	}
	
	@Override
	public void offer(E e) {
		list.addLast(e);	
	}

	@Override
	public E poll() {
		return list.removeFirst();
	}

	@Override
	public E peek() {
		return list.getFirst();
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Queue: [");
		for(int i = 0; i < size(); i++) {
			sb.append(list.get(i).getElement());
			if(i != size() - 1) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
	
}
