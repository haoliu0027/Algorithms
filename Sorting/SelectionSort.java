package com.HL.Sorting;

public class SelectionSort {
	private int[] arr;
	public SelectionSort(int[] array) {
		this.arr = array;
	}
	
	public void SelectionSort() {
		for(int k = 0; k < arr.length - 1; k++) {
			int indexMin = k;
			for(int i = k + 1; i < arr.length; i++) {
				if(arr[indexMin] > arr[i]) indexMin = i;
			}
			swap(indexMin, k);
		}	
	}
	
	public void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
