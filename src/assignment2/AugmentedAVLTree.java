package assignment2;

import java.util.Stack;

public class AugmentedAVLTree {
	private AugmentedAVLNode root;
	Stack<AugmentedAVLNode> s = new Stack<AugmentedAVLNode>();
	int realsum = 0;
	int sum = 0;

	public AugmentedAVLTree() {
		root = null;
	}

	// height of node for rotation
	private int height(AugmentedAVLNode t) {
		return t == null ? -1 : t.height;
	}

	private int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}

	public void insert(int data) {
		root = insert(data, root);
	}

	private AugmentedAVLNode insert(int x, AugmentedAVLNode t) {
		if (t == null)
			t = new AugmentedAVLNode(x);
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
	private AugmentedAVLNode rotateWithLeftChild(AugmentedAVLNode k2) {
		AugmentedAVLNode k1 = k2.left;
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
	private AugmentedAVLNode rotateWithRightChild(AugmentedAVLNode k1) {
		AugmentedAVLNode k2 = k1.right;
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
	private AugmentedAVLNode doubleWithLeftChild(AugmentedAVLNode k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	// case 3 - right-left rotation
	private AugmentedAVLNode doubleWithRightChild(AugmentedAVLNode k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	public int getSum() {
		return getSum(root);
	}

	private int getSum(AugmentedAVLNode r) {
		if (r == null)
			return 0;
		else {
			int sum = r.data;
			sum += getSum(r.left);
			sum += getSum(r.right);
			return sum;
		}
	}

	/* Function for inorder traversal */
	public void inorder() {
		inorder(root);
	}

	private void inorder(AugmentedAVLNode r) {
		if (r != null) {
			inorder(r.left);
			System.out.print(r.data + ":" + r.key + " ");
			inorder(r.right);
		}
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(AugmentedAVLNode r) {
		if (r != null) {
			System.out.print(r.data + ":" + r.key + " ");
			preorder(r.left);
			preorder(r.right);
		}
	}

	public int getMin() {
		return getMin(root);
	}

	private int getMin(AugmentedAVLNode r) {
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

	private int getMax(AugmentedAVLNode r) {
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
			realsum=0;
			 return gss(val,root);
		}
		private int gss(int val,AugmentedAVLNode r) {
			
			if (r != null) {
				s.push(r);
				gss(val,r.left);
				gss(val,r.right);
			} 
			
			while (!s.isEmpty()) {
				AugmentedAVLNode n = s.pop();

				if (val > n.data) {
					realsum += n.data;
				}

			}
			return realsum;
			
		}
		
	
	
	

}
