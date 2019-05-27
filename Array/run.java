package com.HL.Array;

public class run {

	public static void main(String[] args) {
		Array<Integer> arr = new Array(10);
		arr.addFirst(1);
//		System.out.println(arr.size());
//		System.out.println(arr.get(0));
		arr.addFirst(2);
//		System.out.println(arr.size());
//		System.out.println(arr.get(0));
		arr.add(1, 4);
//		System.out.println(arr.size());
//		System.out.println(arr.get(0));
//		System.out.println(arr.get(1));
//		System.out.println(arr.get(2));
		System.out.println(arr.remove(1)); 
		System.out.println(arr.capacity());
		System.out.println(arr.toString());
	}

}
