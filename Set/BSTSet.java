package com.HL.Set;
import com.HL.Tree.*;
public class BSTSet<E extends Comparable<E>> implements Set<E> {
	
	private BST bst;
	public BSTSet() {
		bst = new BST<>();
	}
	
	@Override
	public int size() {
		return bst.size();
	}

	@Override
	public boolean isEmpty() {
		return bst.isEmpty();
	}

	@Override
	public void add(E e) {
		bst.add(e);
		
	}

	@Override
	public void remove(E e) {
		bst.remove(e);
		
	}

	@Override
	public boolean contains(E e) {
		return bst.contains(e);
	}
	
}
