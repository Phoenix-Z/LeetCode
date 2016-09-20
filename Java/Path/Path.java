/**
 * �ݹ��㷨���������ĸ��ڵ�һֱ���£�ÿ�����µ�ʱ���ȥ���ڵ��ֵ
 * @author Phoenix-Z
 *
 */
public class Path {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
    
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
    
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
	
}

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}