package com.HL.Sorting;

import java.util.Arrays;

import com.HL.Array.Array;

public class HeapSort {
	private int[] arr;
	public int size;
	public int size2;
	public HeapSort(int[] array) {
		this.size = array.length;
		this.size2 = array.length;
		this.arr = new int[array.length * 2];
		for(int i = 0; i < array.length ; i++) arr[i] = array[i];
	}
	
	public void heapSort() {
		heapify(arr);
//		for(int i = 0; i < size; i++) {
//			System.out.println(arr[i]);
//		}
		for(int j = 0; j < size; j++) {
//			System.out.println("...."+size + "---size ---");
			int temp = removeMin();
			System.out.println(temp);
			arr[j + size] = temp;
		}
		for(int k = 0; k < size; k++) {
			arr[k] = arr[k + size];
		}
	}
	
	public void heapify(int[] arr) {
		for(int i = size - 1; i > 0; i--) {
			siftUp(i);
		}
	}
	
	public void siftUp(int index) {
		if(index <= 0) return;
		int parent = (index - 1) / 2;
		if(arr[index] < arr[parent]) {
			swap(index, parent);
		}
		siftUp(parent);
	}
	
	public void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public int removeMin() {
		if(size == 0) throw new IllegalArgumentException(" is Empty");
		int temp = arr[0];
		swap(0, size2 - 1);
		siftDown(0);
		size2--;
//		for (int i = 0; i < size; i++) {
//			System.out.println(arr[i]);
//		} 
		return temp;
	}
	
	public void siftDown(int index) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		if(left >= size2) return;
		if(left == size2 - 1) {
			if(arr[left] < arr[index]) {
				swap(index, left);
				return;
			}
		}
		else if(arr[left] < arr[right] && arr[left] < arr[index]) {
			swap(left, index);
			siftDown(left);
		}else if(arr[left] > arr[right] && arr[right] < arr[index]) {
			swap(right, index);
			siftDown(right);
		}
	}
}
