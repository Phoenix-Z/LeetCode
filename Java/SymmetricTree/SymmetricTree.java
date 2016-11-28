/**
 * (1ms)
 * 这是个递归做法，代码简洁易懂，突破口在于需要一个辅助方法传入两个参数。
 * @author Phoenix-Z
 *
 */
public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		return root == null || isSymmetricHelp(root.left, root.right);
	}

	private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
		//这句写的很妙只要left和right有一个为null，只需要判断left和right是否相等(是否都为null)即可
		if (left == null || right == null)
			return left == right;
		//确保left和right均不为null之后，就可以判断他们的值是否相等了
		if (left.val != right.val)
			return false;
		//递归调用，需要注意什么才是对称的树
		return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}