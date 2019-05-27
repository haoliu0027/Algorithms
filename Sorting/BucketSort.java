package com.HL.Sorting;
import java.util.LinkedList;
import java.util.Queue;

public class BucketSort<K, V> {
	
	private int[] arr;
	private int[] aux;
	
	public BucketSort(int[] array) {
		this.arr = array;
		this.aux = new int[array.length];
	}
	
	public Queue<Integer>[] fillBucket(int[] arr){
		if(arr == null) return null;
		else {
			int vMax = arr[0], vMin = arr[0];
			for(int i : arr) {
				if(i > vMax) vMax = i;
				else if(i < vMin) vMin = i;
			}
			Queue<Integer>[] bucket = new Queue[vMax - vMin + 1];
			for(int j = 0; j < bucket.length; j++) bucket[j] = new LinkedList<Integer>();
			for(int k = 0; k < arr.length; k++) bucket[arr[k] - vMin].add(arr[k]);
			return bucket;
		}
	}
	
	public int[] readBucket() {
		int k = 0;
		Queue<Integer>[] bucket = fillBucket(arr);
		for(int i = 0; i < bucket.length; i++) {
			for(int j : bucket[i]) aux[k++] = j;
		}
		return aux;
	}
}
