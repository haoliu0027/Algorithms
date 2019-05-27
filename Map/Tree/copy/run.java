package com.HL.Map.Tree.copy;

public class run {

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.add(4);
		bst.add(2);
		bst.add(5);
		bst.add(1);
		bst.add(7);
		bst.add(6);
		bst.add(3);
		//bst.breathFirstOrder();
		//System.out.println(bst.max());
		bst.remove(2);
		bst.breathFirstOrder();
	}

}
