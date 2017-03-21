/**
 * (44ms)
 * @author Phoenix-Z
 *
 */
public class DiameterOfBinaryTree {
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null)
			return 0;
        int max = Math.max(Math.max(helper(root), helper(root.left)), helper(root.right));
        return Math.max(Math.max(max, diameterOfBinaryTree(root.left)), diameterOfBinaryTree(root.right));
    }
	
	public int helper(TreeNode now) {
		if(now == null)
			return 0;
		return pathLen(now.left) + pathLen(now.right);
	}
	
	public int pathLen(TreeNode now) {
		if(now == null)
			return 0;
		return 1 + Math.max(pathLen(now.left), pathLen(now.right));
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		DiameterOfBinaryTree test = new DiameterOfBinaryTree();
		System.out.println(test.diameterOfBinaryTree(root));
	}
}
