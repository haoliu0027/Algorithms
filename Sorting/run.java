package com.HL.Sorting;

import java.util.LinkedList;

public class run {

	public static void main(String[] args) {
		LinkedList<String> str = new LinkedList<>();
		str.add("ZRH");
		str.add("ARN");
		str.add("AMS");
		str.add("LHR");
		str.add("BCN");
		MSDRedixSort msd = new MSDRedixSort(str);
		msd.MSD();
//		String[] str = {"ZRH" , "ARN" , "AMS", "LHR", "BCN"};
//		LSDRedixSort lsd = new LSDRedixSort(str);
//		lsd.LSD();
//		int[] arr = { 5 , 4, 3, 7};
//		BucketSort bu = new BucketSort<>(arr);
//		arr = bu.readBucket();
//		MaxHeapSort hs = new MaxHeapSort(arr);
//		hs.maxHeapSort();
//		QuickSort qs = new QuickSort(arr);
//		qs.quickSort();
//		MergeSort ms = new MergeSort(arr);
//		ms.MergeSort();
//		InsertionSort is = new InsertionSort(arr);
//		is.InsertionSort();
//		BubbleSort bs = new BubbleSort(arr);
//		bs.BubbleSort();
//		SelectionSort ss = new SelectionSort(arr);
//		ss.SelectionSort();
//		for(int i = 0; i < arr.length ; i++)
//			System.out.print(" result -" +arr[i]);
	}

}
