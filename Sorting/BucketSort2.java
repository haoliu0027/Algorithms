package com.HL.Sorting;

import java.util.HashMap;

public class BucketSort2<K, V>{
	private HashMap<K, V>[] map;
	public BucketSort2(HashMap[] arr) {
		this.map = arr;
	}
	
	public void bucketSort() {
		fillBucket();
	}
	
	private void fillBucket() {
		
	}
}
