package tree;

public class BinarySearchTree <AnyType extends Comparable<? super AnyType>>{

	private static class BinaryNode<AnyType> {
		
		AnyType element;           // The data in the node
		BinaryNode<AnyType> left;  // Left child
		BinaryNode<AnyType> right; // Right child; 
		
		public BinaryNode(AnyType theElement) {
			this(theElement, null, null);
		}
		
		public BinaryNode(AnyType theElement, BinaryNode<AnyType> lKid, BinaryNode<AnyType> rKid) {
			element = theElement;
			left = lKid;
			right = rKid;
		}
		
	}
	
	private BinaryNode<AnyType> root;

	public BinarySearchTree() {
		root = null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public boolean contains(AnyType x) {
		return contains(x, root);
	}

	/**
	 * Internal method to find an item in a subtree.
	 * @param x is item to search for.
	 * @param t the node that roots the subtree.
	 * @return node containing the matched item.
	 */
	private boolean contains(AnyType x, BinaryNode<AnyType> t) {
		if(t == null)
			return false;
		int compareResult = x.compareTo(t.element);
		if(compareResult < 0)
			return contains(x, t.left);
		else if(compareResult > 0)
			return contains(x, t.right);
		return true;     // Match
	}
	
	public AnyType findMin() {
		if(isEmpty())
			throw new RuntimeException("This is a empty tree!");
		return findMin(root).element;
	}

	/**
	 * Internal method to find the smallest item in a subtree.
	 * @param t the node that roots the subtree.
	 * @return node containing the smallest item.
	 */
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
		if(t == null)
			return null;
		else if (t.left == null) {
			return t;
		}
		return findMin(t.left);
	}
	
	public AnyType findMax() {
		if(isEmpty())
			throw new RuntimeException("This is a empty tree!");
		return findMax(root).element;
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 * @param t the node that roots the subtree.
	 * @return node containing the largest item.
	 */
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
		if(t != null) {
			while(t.right != null)
				t = t.right;
		}
		return t;
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
	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
		if(t == null)
			return new BinaryNode<AnyType>(x);
		
		int compareResult = x.compareTo(t.element);
		
		if(compareResult < 0 ) {
			t.left = insert(x, t.left);
		} else if (compareResult > 0) {
			t.right = insert(x, t.right);
		}
		return t;
	}
	
	public void remove(AnyType x) {
		root = remove(x, root);
	}

	/**
	 * Internal method to remove from a subtree.
	 * @param x the item to remove.
	 * @param t the node that roots the subtree.
	 * @return the new root of the subtree.
	 */
	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
		if(t == null)
			return t;    // Item not found; do nothing
		
		int compareResult = x.compareTo(t.element);
		
		if(compareResult < 0) 
			t.left = remove(x, t.left);
		else if(compareResult > 0)
			t.right = remove(x, t.right);
		else if(t.left != null && t.right != null) { 
			// 要删除的节点有两个孩子，先找到右子树中最小的元素，用来替代要删除的节点
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		} else { 
			// 要删除的节点只有一个孩子，直接用那个孩子取代要删除的节点即可
			t = (t.left != null) ? t.left : t.right;
		}
		return t;
	}
	
	/**
	 * Print the tree contents in sorted order.
	 */
	public void printTree() {
		if(isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}

	/**
	 * Internal method to print a subtree in sorted order.
	 * @param t the node that roots the subtree.
	 */
	private void printTree(BinaryNode<AnyType> t) {
		if(t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
	
}
