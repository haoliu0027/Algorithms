package com.HL.LinkedList;

import com.HL.Iterator.*;
import com.HL.Iterator.SLLIterator;

public class run {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.addFirst(0);
		list.addLast(2);
		list.addLast(3);
		Iterator<Integer> it = list.myIterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

}
