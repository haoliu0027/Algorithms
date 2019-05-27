package com.HL.Heap;

public interface Heap<K, E> {
	E min();
	E removeMin();
	void insert(K key, E value);
	int size();
	boolean isEmpty();
}
