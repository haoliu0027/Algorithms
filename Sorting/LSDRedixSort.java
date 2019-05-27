package com.HL.Sorting;

import java.util.ArrayList;

public class LSDRedixSort {
	
	private String[] str;
	
	public LSDRedixSort(String[] string) {
		this.str = string;
	}
	
	public void LSD() {
		String[] aux = fillBuckets();
		for(String s: aux)System.out.println(s);
	}
	
	private String[] fillBuckets() {
		if(str.length == 0) return new String[0];
		ArrayList<String>[] buckets = new ArrayList[26];
		int strLen = 3;
		for(int i = 0; i < buckets.length; i++) buckets[i] = new ArrayList<>();
		for(int j = strLen - 1; j >= 0; j--) {
			for(String s : str) {
				//System.out.println(s.charAt(j) - 'A');
				buckets[s.charAt(j) - 'A'].add(s);
			}
			int index = 0;
			for(ArrayList<String> thisBucket : buckets) {
				for(String s : thisBucket) str[index++] = s;
				thisBucket.clear();
			}
		}
		return str;
		
	}
	
}
