package com.HL.Map;

public interface Map<K, V> {
	int size();
	boolean contains(K key);
	boolean isEmpty();
	void put(K key, V value);
	V remove(K key);
	V get(K key);
	void set(K key, V value);
}
