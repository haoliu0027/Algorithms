package com.HL.Map;

public class run {

	public static void main(String[] args) {
		BSTMap<String, Integer> map = new BSTMap<>();
//		LinkedListMap<String, Integer> map = new LinkedListMap<>();
		map.put("s", 1);
		map.put("e", 2);
		map.put("a", 3);
		map.put("f", 4);
		map.BFS();
		//System.out.println(map.get("s"));
//		System.out.println(map.get(0).value);
//		System.out.println(map.get(1).value);
//		System.out.println(map.get(2).value);

	}

}
