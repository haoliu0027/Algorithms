package com.HL.Heap;

import java.util.Random;

public class run {

	public static void main(String[] args) {
		MaxHeap<Integer> heap = new MaxHeap<>();
		int n = 10000;
		Random random = new Random();
		for(int i = 0; i < n; i++) {
			heap.add(random.nextInt(Integer.MAX_VALUE));
		}
		
		int[] arr = new int[n];
		for(int j = 0; j < n; j++) {
			arr[j] = heap.removeMax();
		}
		
		for(int k = 1; k < n; k++) {
			if(arr[k-1] < arr[k]) {
				System.out.println("not right");
				break;
			}
		}
		System.out.println("right");
	}

}
