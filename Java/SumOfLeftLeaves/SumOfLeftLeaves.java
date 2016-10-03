/**
 * (9ms)
 * 递归的做法
 * @author Phoenix-Z
 *
 */
public class SumOfLeftLeaves {

	
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) 
			return 0;
		//判断是否有左子树，然后判断这个左子树是否为叶子，如果是叶子节点，就返回该节点的值
		//然后递归判断左子树和右子树
        return ( (root.left != null && root.left.right == null 
        		&& root.left.left == null) ? root.left.val : 0 )
        + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
	
	//这也是个递归的做法，思路与上面是一样的，不过加了一个helper方便理解。
	public int sumOfLeftLeavesWithHelper(TreeNode root) {
        return helper(root, false);
    }
    
	//helper增加一个形参表示该子树是否为左子树
    public int helper(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && isLeft) return root.val;
        int left = helper(root.left, true);
        int right = helper(root.right, false);
        return left + right;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(-1);
		TreeNode node6 = new TreeNode(5);
		TreeNode node7 = new TreeNode(1);
		TreeNode node8 = new TreeNode(6);
		TreeNode node9 = new TreeNode(8);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.right = node8;
		node5.right = node9;
		System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(root));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}