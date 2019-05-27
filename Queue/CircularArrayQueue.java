package com.HL.Queue;
public class CircularArrayQueue<E> implements Queue<E> {
	
	E[] array;
	int head, tail, size;
	
	public CircularArrayQueue(int capacity) {
		array = (E[])new Object[capacity + 1];
		head = tail = size = 0;
	}
	
	public CircularArrayQueue() {
		this(10);
	}
	
	@Override
	public void offer(E e) {
		if((tail + 1) % array.length == head) resize(capacity() * 2);
		array[size] = e;
		size++;
		tail = size % array.length;
	}
	
	public void resize(int capacity) {
		E[] data = (E[])new Object[capacity + 1];
		for(int i = 0; i < size; i++) {
			data[i] = array[(i + head) % array.length]; 
		}
		array = data;
		head = 0;
		tail = size;
	}

	@Override
	public E poll() {
		if(isEmpty()) throw new IllegalArgumentException("is Empty");
		E temp = array[head];
		array[head] = null;
		head = (head + 1) % array.length;
		size--;
		if(size <= capacity()/4 && capacity()/2 != 0) resize(capacity()/2);
		return temp;
	}

	@Override
	public E peek() {
		if(isEmpty()) throw new IllegalArgumentException("is Empty");
		else{
			return array[head];
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == tail;
	}
	
	public int capacity() {
		return array.length - 1;
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Queue: [");
		for(int i = head; i != tail; i = (i+1) % array.length) {
			sb.append(array[i]);
			if(i != tail - 1) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
	
}
