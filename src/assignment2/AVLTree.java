package assignment2;

import java.util.Stack;

public class AVLTree {
	private AVLNode root;
	Stack<AVLNode> s = new Stack<AVLNode>();
	int realsum = 0;
	int sum = 0;

	public AVLTree() {
		root = null;
	}

	// height of node for rotation control
	private int height(AVLNode t) {
		return t == null ? -1 : t.height;
		
	}
	
	private int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}

	public void insert(int data) {
		root = insert(data, root);
	}

	private AVLNode insert(int x, AVLNode t) {
		if (t == null)
			t = new AVLNode(x);
		else if (x < t.data) {

			t.left = insert(x, t.left);
			t.left.parent = t;
			if (height(t.left) - height(t.right) == 2)
				if (x < t.left.data)
					t = rotateWithLeftChild(t);// case1
				else
					t = doubleWithLeftChild(t);// case2
		} else if (x > t.data) {

			t.right = insert(x, t.right);
			t.right.parent = t;
			if (height(t.right) - height(t.left) == 2)
				if (x > t.right.data)
					t = rotateWithRightChild(t);// case4
				else
					t = doubleWithRightChild(t);// case3
		} else
			; // Duplicate; do nothing
		t.height = max(height(t.left), height(t.right)) + 1;
		return t;
	}

	// case 1 - rotate right
	private AVLNode rotateWithLeftChild(AVLNode k2) {
		AVLNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k1.parent = k2.parent;
		k2.parent = k1;

		if (k2.left != null) {
			k2.left.parent = k2;
		}

		k2.height = max(height(k2.left), height(k2.right)) + 1;
		k1.height = max(height(k1.left), k2.height) + 1;

		return k1;
	}

	// case 4 - rotate left
	private AVLNode rotateWithRightChild(AVLNode k1) {
		AVLNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k2.parent = k1.parent;
		k1.parent = k2;

		if (k1.right != null) {
			k1.right.parent = k1;
		}

		k1.height = max(height(k1.left), height(k1.right)) + 1;
		k2.height = max(height(k2.right), k1.height) + 1;

		return k2;
	}

	// case 2 - left-right rotation
	private AVLNode doubleWithLeftChild(AVLNode k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	// case 3 - right-left rotation
	private AVLNode doubleWithRightChild(AVLNode k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	
	
	
	
	public int getSum() {
		return getSum(root);
	}

	private int getSum(AVLNode r) {
		if (r == null)
			return 0;
		else {
			int sum = r.data;
			sum += getSum(r.left);
			sum += getSum(r.right);
			return sum;
		}
	}

	
	
	//inorder traversal
	public void inorder() {
		inorder(root);
	}

	private void inorder(AVLNode r) {
		if (r != null) {
			inorder(r.left);
			System.out.print(r.data + " ");
			inorder(r.right);
		}
	}

	
	
	//preorder traversal for controlling root 
	public void preorder() {
		preorder(root);
	}

	private void preorder(AVLNode r) {
		if (r != null) {
			System.out.print(r.data);
			preorder(r.left);
			preorder(r.right);
		}
	}

	public int getMin() {
		return getMin(root);
	}

	private int getMin(AVLNode r) {
		int min = 0;
		if (r.left == null) {
			min = r.data;
		} else {
			while (r.left != null) {
				r = r.left;
			}
			min = r.data;
		}
		return min;
	}

	public int getMax() {
		return getMax(root);
	}

	private int getMax(AVLNode r) {
		int max = 0;
		if (r.right == null) {
			max = r.data;
		} else {
			while (r.right != null) {
				r = r.right;
			}
			max = r.data;
		}
		return max;
	}
    // this methods control the tree inorderly and add to stack
	public int gss(int val) {
		 return gss(val,root);
	}
	private int gss(int val,AVLNode r) {

		if (r != null) {
			s.push(r);
			gss(val,r.left);
			gss(val,r.right);
		} 	
		
		while (!s.isEmpty()) {
			AVLNode n = s.pop();

			if (val > n.data) {
				realsum += n.data;
			}

		}
		return realsum;
		
	}
	
	

}