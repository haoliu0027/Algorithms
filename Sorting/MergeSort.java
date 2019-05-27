package com.HL.Sorting;

import java.util.Arrays;

public class MergeSort {
	private int[] arr;
	public MergeSort(int[] array) {
		this.arr = array;
	}
	public void MergeSort() {
		int low = 0;
		int high = arr.length - 1;
		mergeSort(arr, low, high);
	}
	private void mergeSort(int[] arr, int low, int high) {
		if(low >= high) return;
		int mid = low + ((high - low)/2);
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, high, mid);
	}
	private void merge(int[] arr, int low, int high, int mid) {
	    int[] aux = new int[arr.length];
	    for(int i = low; i <= high; i ++)
	      aux[i] = arr[i];
	    int i = low, j = mid + 1;
	    for(int k = low; k <= high; k++){
	      if(i > mid) {
	        arr[k] = aux[j];
	        j++;
	      }else if(j > high){
	        arr[k] = aux[i];
	        i++;
	      }else if(aux[i] < aux[j] ){
	        arr[k] = aux[i];
	        i++;
	      }else{
	        arr[k] = aux[j];
	        j++;
	      }
	    }
//		int[] aux = new int[high - low + 1];
//		for(int i = 0; i < aux.length; i++) {
//			aux[i] = arr[i + low];
//		}
//		int i = low, j = mid+1;
//		for(int k = low; k <= high; k++) {
//			if(i > mid) {
//				arr[k] = aux[j - low];
//				j++;
//			}else if(j > high) {
//				arr[k] = aux[i - low];
//				i++;
//			}else if(aux[i - low] < aux[j - low]) {
//				arr[k] = aux[i - low];
//				i++;
//			}else {
//				arr[k] = aux[j - low];
//				j++;
//			}
//		}
		
	}
}
