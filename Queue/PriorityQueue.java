package com.HL.Queue;
import com.HL.Heap.MaxHeap;
public class PriorityQueue<E extends Comparable<E>> implements Queue<E>  {
	MaxHeap<E> PQ;
	public PriorityQueue() {
		PQ = new MaxHeap<>();
	}
	
	@Override
	public void offer(E e) {
		PQ.add(e);
	}

	@Override
	public E poll() {
		return PQ.removeMax();
	}

	@Override
	public E peek() {
		return PQ.getMax();
	}

	@Override
	public int size() {
		return PQ.size();
	}

	@Override
	public boolean isEmpty() {
		return PQ.isEmpty();
	}

}
