package com.HL.BinarySerach;

public class BinarySearchByWhile {

	public static void main(String[] args) {
		int[] sortedArr = {1,2,3,4,5,6,7,8,9};
		int target = 7;
		int low = 0;
		int high = sortedArr.length - 1;
		while(low < high) {
			int mid = low +((high - low)>>2);
			if(sortedArr[mid] == target) {
				System.out.println("true");
				break;
			}
			else if(sortedArr[mid] < target) low = mid+1;
			else high = mid - 1;
		}
	}

}
