package com.HL.Heap;

import com.HL.Array.Array;

public class MaxHeap<E extends Comparable<E>> {
	private Array<E> data;
	
	public MaxHeap(int capacity) {
		data = new Array<>(capacity);
	}
	
	public MaxHeap() {
		this(10);
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public int parent(int index) {
		if(index == 0) throw new IllegalArgumentException(" DOnt have a father node");
		return (index - 1)/2;
	}
	
	public int left(int index) {
		return 2*index + 1;
	}
	
	public int right(int index) {
		return 2*index + 2;
	}
	
	public void add(E e) {
		data.addLast(e);
		siftUp(size() - 1);
	}
	
	public void siftUp(int index) {
		if(index <= 0) return;
		int par = parent(index);
		if(data.get(index).compareTo(data.get(par)) > 0) data.swap(index, par);
		siftUp(par);
	}
	
	public E getMax() {
		if(isEmpty()) return null;
		return data.get(0);
	}
	
	public E removeMax() {
		if(isEmpty()) return null;
		E temp = getMax();
		data.swap(0, size()-1);
		data.removeLast();
		siftDown(0);
		return temp;
	}
	
	public void siftDown(int index) {
		while(left(index) < size()) {
			int j = left(index);
			if(j+1 < data.size() && (data.get(j).compareTo(data.get(j+1)) < 0)) j++;
			if(data.get(j).compareTo(data.get(index)) < 0) break;
			if(data.get(j).compareTo(data.get(index)) > 0) data.swap(j, index);
			index = j;
		}
	}
	
	public void heapify(E[] data) {
		Array<E> arr = new Array<>(data);
		for(int i = parent(size() - 1); i > 0; i--) {
			siftDown(i);
		}
	}
	
	public E replace(E e) {
		E temp = getMax();
		data.set(0, e);
		siftDown(0);
		return temp;
	}
	
}
