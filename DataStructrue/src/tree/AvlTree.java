package tree;

import java.util.Comparator;

public class AvlTree<AnyType> {
	
	private AvlNode<AnyType> root;
	private Comparator<? super AnyType> comparator;
	
	public AvlTree() {
		this(null);
	}
	
	public AvlTree(Comparator<? super AnyType> c) {
		root = null;
		comparator = c;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private int myCompare(AnyType lhs, AnyType rhs) {
		if(comparator != null) {
			return comparator.compare(lhs, rhs);
		} else {
			return ((Comparable)lhs).compareTo(rhs);
		}
	}
	
	private static class AvlNode<AnyType> {
		
		AnyType element;         // The data in the node
		AvlNode<AnyType> left;   // Left child
		AvlNode<AnyType> right;  // Right child
		int height;              // Height
		
		public AvlNode(AnyType theElement) {
			this(theElement, null, null);
		}

		public AvlNode(AnyType element, AvlNode<AnyType> left, AvlNode<AnyType> right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
		
		/**
		 * @return the height of node t, or -1, if null.
		 */
	}
	
	private int height(AvlNode<AnyType> t) {
		return t == null? -1 : t.height;
	}
	
	public void insert(AnyType x) {
		root = insert(x, root);
	}
	
	/**
	 * Internal method to insert into a subtree.
	 * @param x the item to insert.
	 * @param t the node that roots the subtree.
	 * @return the new root of the subtree.
	 */
	private AvlNode<AnyType> insert(AnyType x, AvlNode<AnyType> t) {
		if(t== null)
			return new AvlNode<AnyType>(x);
		
		int compareResult = myCompare(x, t.element);
		
		if(compareResult < 0) {
			t.left = insert(x, t.left);
			if(height(t.left) - height(t.right) == 2) {
				if(myCompare(x, t.left.element) < 0)
					t = rotateWithLeftChild(t);
				else
					t = doubleWithLeftChild(t);
			}
		} else if (compareResult > 0) {
			t.right = insert(x, t.right);
			if(height(t.right) - height(t.left) == 2) {
				if(myCompare(x, t.right.element) > 0)
					t = rotateWithRightChild(t);
				else
					t = doubleWithRightChild(t);
			}
		}
		
		t.height = Math.max(height(t.left), height(t.right));
		return t;
	}

	private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k3) {
		k3.right = rotateWithLeftChild(k3.right);
		return rotateWithRightChild(k3);
	}

	private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k2) {
		AvlNode<AnyType> k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(k2.height, height(k1.right)) + 1;
		return k1;
	}

	/**
	 * Double rotate binary tree node: first left child
	 * with its right child; then node k3 with new left child.
	 * For AVL trees, this is a double rotation for case 2.
	 * Update heights, then return new root.
	 */
	private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	/**
	 * Rotate binary tree node with left child.
	 * For AVL trees, this is a single rotation for case 1.
	 * Update heights, then return new root.
	 */
	private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {
		AvlNode<AnyType> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;
		return k1;
	}
	
}
