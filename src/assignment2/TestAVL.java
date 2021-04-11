package assignment2;

import java.util.ArrayList;
import java.util.Random;

public class TestAVL {
	
	public static AVLTree avlt = new AVLTree();
	public static AugmentedAVLTree augavlt = new AugmentedAVLTree();

	public static void main(String[] args) {
		
		int given_value = 1000;
		int random_value = 2000;
		
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 0; i < given_value; i++) {
			Random rnd = new Random();
			int number = rnd.nextInt(random_value)+1;
			ar.add(number);
		}
		//////////////// AVL TREE INSERTION
		long startTimeInsert = System.nanoTime();
		for (int i = 0; i < given_value; i++) {
			avlt.insert(ar.get(i));
		}
		long endTimeInsert = System.nanoTime();
		long estimatedTimeInsert = endTimeInsert - startTimeInsert;
		
		////////////////AUGMENTED AVL TREE INSERTION
		long startTimeInsert2 = System.nanoTime();
		for (int i = 0; i < given_value; i++) {
			augavlt.insert(ar.get(i));
		}
		long endTimeInsert2 = System.nanoTime();
		long estimatedTimeInsert2 = endTimeInsert2 - startTimeInsert2;
		
		////////////////AVL TREE SUM
		long startTimeSum = System.nanoTime();
		int sum = avlt.getSum();
		long endTimeSum = System.nanoTime();
		long estimatedTimeSum = endTimeSum - startTimeSum;
		
		////////////////AUGMENTED AVL TREE SUM
		long startTimeSum2 = System.nanoTime();
		int sum2 = augavlt.getSum();
		long endTimeSum2 = System.nanoTime();
		long estimatedTimeSum2 = endTimeSum2 - startTimeSum2;
				
		System.out.print("------ AVL-Tree ------\nAll items were inserted.");		
		//System.out.print("\nIn-order:\n");avlt.inorder();
		System.out.print("\nThe time elapsed for the insertion of all items is " + estimatedTimeInsert + " nanoseconds");
		System.out.print("\nThe result of GETSUMSMALLER for the item with value "+given_value+" is "+avlt.gss(given_value));
		System.out.print("\nThe maximum value of all items is " + avlt.getMax()+"\nThe minimum value of all items is " + avlt.getMin());
		System.out.print("\nThe summation of all items is " + sum+"\nThe time elapsed for GETSUM is " + estimatedTimeSum + " nanoseconds");
		
		System.out.println("\n");
		
		System.out.print("------ Augmented AVL-Tree ------\nAll items were inserted.");		
		//System.out.print("\nIn-order:\n");augavlt.inorder();// prints data and key, key is GETSUMSMALLER current node of avl tree
		System.out.print("\nThe time elapsed for the insertion of all items is " + estimatedTimeInsert2 + " nanoseconds");
		System.out.print("\nThe result of GETSUMSMALLER for the item with value "+given_value+" is "+augavlt.gss(given_value));
		System.out.print("\nThe maximum value of all items is " + augavlt.getMax()+"\nThe minimum value of all items is " + augavlt.getMin());
		System.out.print("\nThe summation of all items is " + sum2+"\nThe time elapsed for GETSUM is " + estimatedTimeSum2 + " nanoseconds");
	
	}
	
	

}
