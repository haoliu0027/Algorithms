package com.HL.Map;

public class LinkedListMap<K extends Comparable<K>, V > implements Map<K, V> {
	public class Node<K, V>{
		public K key;
		public V value;
		public Node<K, V> next;
		public Node(K key, V value, Node<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	private Node<K, V> head;
	private int size;
	
	public LinkedListMap(){
		head = null;
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(K key) {
		if(isEmpty()) return false;
		else {
			Node<K, V> curr = head;
			for(int i = 0; i < size; i++) {
				if(curr.key == key) return true;
				curr = curr.next;
			}
			return false;
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void put(K key, V value) {
		boolean judge = false;
		if(isEmpty()) {
			head = new Node(key, value, null);
			size++;
		}else {
			if(contains(key)) throw new IllegalArgumentException("Map already has this key");
			else {
				Node<K, V> aux = new Node(key, value, null);
				for(int i = 0; i < size; i++) {
					if(key.compareTo(get(i).key) < 0) {
						if(i == 0) {
							aux.next = head;
							head = aux;
							size++;
							judge = true;
							break;
						}else {
							Node prev = get(i - 1);
							Node next = get(i);
							prev.next = aux;
							aux.next = next;
							size++;
							judge = true;
							break;
						}
					}
				}
				if(judge == false) {
					Node prev = get(size - 1);
					prev.next = aux;
					size++;
				}
			}
		}
	}
	
	public int getIndex(K key) {
		if(!contains(key)) return -1;
		else {
			for(int i = 0; i < size; i++)
				if(get(i).key.equals(key)) return i;
			return -1;
		}
	}
	
	@Override
	public V remove(K key) {
		if(isEmpty() || (!contains(key))) return null;
		else {
			int index = getIndex(key);
			V temp = get(index).value;
			if(index == 0) {
				if(size == 1) {
					head = null;
					size--;
				}else {
					Node next = head.next;
					head.next = null;
					head = next;
					size--;
				}
			}else if(index == size-1) {
				if(size == 1) {
					head = null; size--;
				}else {
					Node prev = get(size - 2);
					prev.next = null;
					size--;
				}
			}
			else {
				Node prev = get(index - 1);
				Node next = get(index + 1);
				Node curr = get(index);
				prev.next = next;
				curr.next = null;
				size--;
			}
			return temp;
		}
	}
	
	public Node<K, V> get(int i){
		if(i < 0 || i >= size) return null;
		else {
			Node<K, V> aux = head;
			for(int j = 0; j < i; j++)
				aux = aux.next;
			return aux;
		}
	}

	@Override
	public V get(K key) {
		if(!contains(key)) return null;
		else {
			for(int i = 0; i < size; i++)
				if(get(i).key.equals(key)) return get(i).value;
			return null;
		}
	}

	@Override
	public void set(K key, V value) {
		if(!contains(key)) return;
		else {
			Node<K, V> curr = get(getIndex(key));
			curr.value = value;
		}
	}

}
