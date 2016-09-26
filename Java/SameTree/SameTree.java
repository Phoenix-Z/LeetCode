/**
 * (0ms)
 * 判断两棵树是否相同(结构相同且节点中的值也相同)，使用递归算法,递归的重点是p和q都为null
 * 需要注意的是在判断两个节点的值是否相等之前，需要确保任一个节点不为null，否则直接返回false(结构不同)
 * @author Phoenix-Z
 *
 */
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		//递归终点
		if(p == null && q == null)
			return true;
		//如果当前两个节点的值相同，需要比较左子树和右子树
		if(p != null && q != null && p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
	
	public static void main(String[] args) {
		
	}
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}