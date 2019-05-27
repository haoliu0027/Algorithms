package com.HL.HashCode;
import java.util.TreeMap;

public class HashTable<K, V> {
	private static final int upperTol = 10;
	private static final int lowerTol = 2;
	private TreeMap<K, V>[] hashTable;
	private int M;
	private int size;
	
	public HashTable(int M) {
		this.M = M;
		size = 0;
		hashTable = new TreeMap[M];
		for(int i = 0; i < M; i++) {
			hashTable[i] = new TreeMap<>();
		}
	}
	
	private int hash(K key) {
		return (key.hashCode() & 0x7777777) % M;
	}
	
	private int size() {
		return size;
	}
	
	public void add(K key, V value) {
		TreeMap<K, V> map = hashTable[hash(key)];
		if(map.containsKey(key)) map.put(key, value);
		else {
			map.put(key, value);
			size++;
		}
		if(size >= upperTol * M) resize(M * 2);
	}
	
	public V remove(K key) {
		TreeMap<K, V> map = hashTable[hash(key)];
		V ret = null;
		if(map.containsKey(key)) {
			ret = map.remove(key);
			size--;
			
			if(size < lowerTol * M && M / 2 > 0) {
				resize(M / 2);
			}
		}
		return ret;
	}
	
	private void resize(int m) {
		TreeMap<K, V>[] aux = new TreeMap[m];
		for(int i = 0; i < m; i++) aux[i] = new TreeMap<>();
		
		int oldM = M;
		this.M = m;
		
		for(int j = 0; j < oldM; j++) {
			TreeMap<K, V> map = hashTable[j];
			for(K key: map.keySet()) {
				aux[hash(key)].put(key, map.get(key));
			}
		}
		
		this.hashTable = aux;
	}
	
	public void set(K key, V value) {
		TreeMap<K, V> map = hashTable[hash(key)];
		if(!map.containsKey(key)) {
			throw new IllegalArgumentException(" Doesnt exist");
		}
		map.put(key, value);
	}
	
	public boolean contains(K key) {
		TreeMap<K, V> map = hashTable[hash(key)];
		if(map.containsKey(key)) return true;
		else return false;
	}
	
	public V get(K key) {
		return hashTable[hash(key)].get(key);
	}
}
