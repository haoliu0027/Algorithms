package com.HL.BinarySerach;

public class BinarySearch {

	public static void main(String[] args) {
		int[] sortedArr = {1,2,3,4,5,6,7,8,9};
		int target = 7;
		int low = 0;
		int high = sortedArr.length - 1;
		System.out.println(binarySearch(sortedArr, low, high, target)); 
	}
	
	public static boolean binarySearch(int[] arr, int low, int high, int target) {
		if(low >= high) return false;
		int mid = low + ((high - low) >> 1);
		if(arr[mid] == target) return true;
		return arr[mid] < target ? binarySearch(arr, mid + 1, high, target) :binarySearch(arr, low, mid-1, target);
	}

}
