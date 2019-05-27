package com.HL.Set;

import java.util.ArrayList;

public class run {
	public static void main(String[] args) {
		System.out.println("Pride and Prejudice");
		
		ArrayList<String> words = new ArrayList<>();
		FileOperation.readFile("pride-and-prejudice.txt", words);
		
		System.out.println(words.size());
		
		BSTSet<String> bst = new BSTSet<>();
		for(String i: words) {
			bst.add(i);
		}
		System.out.println(bst.size());
	}
}
