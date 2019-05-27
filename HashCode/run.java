package com.HL.HashCode;

import java.util.HashMap;
import java.util.HashSet;

public class run {
	public static void main(String[] args) {
		int i = 0;
		System.out.println(((Integer)i).hashCode());
		
		String s = "Hao Liu";
		System.out.println(s.hashCode());
		
		Student stu = new Student(20, 3, "Hao", "Liu");
		System.out.println(stu.hashCode());
		
		HashSet<Student> set = new HashSet<>();
		set.add(stu);
		
		HashMap<Student, Integer> score = new HashMap<>();
		score.put(stu, 100);
	}
}
