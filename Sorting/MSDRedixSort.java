package com.HL.Sorting;

import java.util.LinkedList;

public class MSDRedixSort {
	
	private LinkedList<String> list;
	LinkedList<String> other = new LinkedList();
	public MSDRedixSort(LinkedList<String> aux) {
		this.list = aux;
	}
	
	public void MSD() {
		LinkedList<String> s;
		int index = 0;
		s = MSDSort(list, index);
		for(String i : s)System.out.println(i);
	}
	
	private LinkedList<String> MSDSort(LinkedList<String> list1, int index) {
		LinkedList<String>[] buckets = new LinkedList[26];
		for(int i = 0; i < buckets.length; i++) buckets[i] = new LinkedList<>();
		for(int j = 0; j < list1.size(); j++) {
			buckets[(int)list1.get(j).charAt(index) - 'A'].add(list1.get(j));
		}
		for(LinkedList<String> k : buckets) {
			if(k.size() > 1) {
				MSDSort(k, index + 1);
			}else {
				other.addAll(k);
			}
		}
		return other;
	}

}
