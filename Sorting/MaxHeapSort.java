package com.HL.Sorting;

public class MaxHeapSort {
	int[] arr;
	public MaxHeapSort(int[] array) {
		this.arr = array;
	}
	
	public void maxHeapSort() {
		heapify(arr);
		for(int i : arr) System.out.print(i);
		for(int j = arr.length - 1; j >= 0; j--) {
			swap(j, 0);
			siftDown(0, j - 1);
		}
	}
	
	public void heapify(int[] arr) {
		for(int i = arr.length - 1; i >= 0; i--)
			siftDown(i, arr.length - 1 );
	}
	
	public void siftDown(int index, int range) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		if(left > range) return;
		else if(left == range) {
			if(arr[left] > arr[index]) swap(left, index);
			return;
		}else if(arr[left] > arr[right] && arr[left] > arr[index]) {
			swap(left, index);
			siftDown(left, range);
		}else if(arr[left] < arr[right] && arr[right] > arr[index]) {
			swap(right, index);
			siftDown(right, range);
		}
	}
	
	public void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
