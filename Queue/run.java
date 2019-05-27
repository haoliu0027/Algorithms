package com.HL.Queue;

public class run {

	public static void main(String[] args) {
//		ArrayQueue<Integer> aq = new ArrayQueue<>();
		CircularCLLQueue<Integer> aq = new CircularCLLQueue<>();
		aq.offer(1);
		aq.offer(2);
		aq.offer(3);
		aq.offer(4);
		aq.poll();
		aq.poll();
		aq.poll();
		aq.offer(5);
		aq.offer(6);
		System.out.println(aq.toString());
		System.out.println(aq.size());
		System.out.println(aq.isEmpty());
		System.out.println(aq.peek());
		System.out.println(aq.toString());
	}
}
