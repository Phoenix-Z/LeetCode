/**
 * (1ms)
 * 一个递归的做法，但有些细节需要注意
 * @author Phoenix-Z
 *
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
    	if(root == null)
        	return 0;
    	//如果左右子树同时存在，那就取左右子树最小深度
        if(root.left != null && root.right != null)
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        //如果右子树不存在，而有左子树，当前节点不是叶子，所以需要取左子树的最小深度，而不是0
        if(root.left != null)
            return 1 + minDepth(root.left);
        //左子树不存在，右子树存在
        return 1 + minDepth(root.right);
    }
	
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}