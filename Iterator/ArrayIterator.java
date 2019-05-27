package com.HL.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
	
	private int i = 0;
	private boolean removable = false;
	
	public ArrayIterator() {
		
	}
	
	public Iterator<E> iterator(){
		return new ArrayIterator();
	}
	
	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
}
