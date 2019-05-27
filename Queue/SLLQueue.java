package com.HL.Queue;
import com.HL.LinkedList.SinglyLinkedList;
public class SLLQueue<E> implements Queue<E> {
	SinglyLinkedList<E> SLL;
	
	public SLLQueue() {
		SLL = new SinglyLinkedList<>();
	}
	
	@Override
	public void offer(E e) {
		SLL.addLast(e);
	}

	@Override
	public E poll() {
		return SLL.removeFirst();
	}

	@Override
	public E peek() {
		return SLL.getFirst();
	}

	@Override
	public int size() {
		return SLL.size();
	}

	@Override
	public boolean isEmpty() {
		return SLL.isEmpty();
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Queue: [");
		for(int i = 0; i < size(); i++) {
			sb.append(SLL.get(i).getElement());
			if(i != size() - 1) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
}
