package com.HL.Sorting;

public class InsertionSort {

	private int[] arr;
	public InsertionSort(int[] array) {
		this.arr = array;
	}
	
	public void InsertionSort() {
		for(int i = 1; i < arr.length; i ++) {
			for(int j = i - 1; j >= 0; j--) {
				if(arr[j] > arr[j + 1]) swap(j, j+1);
			}
		}
	}
	
	public void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
