package com.HL.Sorting;

public class BubbleSort {
	private int[] arr;
	public BubbleSort(int[] array) {
		this.arr = array;
	}
	
	public void BubbleSort() {
		for(int i = arr.length - 1; i >= 1; i--) {
			int indexMax = i;
			for(int j = i - 1; j >= 0; j--) {
				if(arr[indexMax] < arr[j]) indexMax = j;
			}
			swap(indexMax, i);
		}
	}
	public void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
