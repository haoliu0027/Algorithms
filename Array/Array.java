package com.HL.Array;

public class Array<E> {
	private E[] data;
	private int size;
	private int capacity;
	
	public Array(int capacity) {
		this.data = (E[]) new Object[capacity];
		this.size = 0;
		this.capacity = capacity;
	}
	
	public Array() {
		this(10);
	}
	
	public Array(E[] arr) {
		data = (E[]) new Object[arr.length];
		for(int i = 0; i < data.length; i++) {
			data[i] = arr[i];
		}
		size = arr.length;
	}
	
	public int size() {
		return size;
	}
	
	public int capacity() {
		return capacity;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void resize(int num) {
		capacity = num;
		E[] aux = (E[]) new Object[capacity]; 
		for(int i = 0; i < size; i++) aux[i] = data[i];
		data = aux;
	}
	
	public void addLast(E e) {
		add(size, e);
	}
	
	public void addFirst(E e) {
		add(0, e);
	}
	
	public void add(int index, E e) {
		if(index < 0 || index > size)
			throw new IllegalArgumentException(" Index is not in the range !");
		if(size == capacity) 
			resize(capacity*2);
		for(int i = size; i > index; i--) {
			data[size] = data[size - 1];
		}
			data[index] = e;
			size++;
	}
	
	public E get(int index) {
		if(index < 0 || index >= size ) 
			throw new IllegalArgumentException(" Index is not in the range !");
		return data[index];
	}
	
	public E getFirst() {
		return get(0);
	}
	
	public E getLast() {
		return get(size - 1);
	}
	
	public boolean contains(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i] == e) return true;
		}
		return false;
	}
	
	public int find(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i] == e) return i;
		}
		return -1;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size-1);
	}
	
	public E removeElement(E e) {
		return find(e) == -1 ? null: remove(find(e));
	}
	
	public E remove(int index) {
		if(index < 0 || index >= size) throw new IllegalArgumentException(" Index is not in the range !");
		E temp = data[index];
		for(int i = index; i < size-1; i++) data[i] = data[i + 1];
		size --;
		data[size] = null;
		if(size == capacity/4) {
			resize(capacity / 2);
		}
		return temp;
	}
	
	public E[] shallowClone() {
		return data;
 	}
	
	public E[] deepClone() {
		E[] aux = (E[]) new Object[capacity];
		for(int i = 0; i < size; i++) aux[i] = data[i];
		return aux;
	}
	
	public void swap(int i, int j) {
		if(i < 0 || i >= size || j < 0 || j >= size) throw new IllegalArgumentException("i, j are not correct");
		E temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	public void set(int index, E e) {
		if(index < 0 || index >= size) return;
		data[index] = e;
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Array: size = % d, capacity = %d\n", size, capacity));
		sb.append("[");
		for(int i = 0; i < size; i ++) {
			sb.append(data[i]);
			if(i != size - 1) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
	
}
