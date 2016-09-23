/**
 * (1ms)
 * 递归解决问题
 * @author Phoenix-Z
 *
 */
public class DepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
        if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}