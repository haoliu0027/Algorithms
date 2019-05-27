package com.HL.Sorting;

public class QuickSort {
	private int[] arr;
	public QuickSort(int[] array) {
		this.arr = array;
	}
	
	public void quickSort() {
		int low = 0, high = arr.length - 1;
		quickSort(low, high);
	}
	
	private void quickSort(int low, int high) {
		if(low >= high) return;
		int p = partation(low, high);
		quickSort(low, p - 1);
		quickSort(p+1, high);
	}
	public int partation(int low, int high) {
		int pivot = arr[low];
		int j = low;
		for(int i = low + 1; i <= high; i++) {
			if(pivot > arr[i]) {
				j++;
				swap(j, i);
			}
		}
		swap(low, j);
		return j;
	}
	public void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
