import com.phoenix.util.TreeNode;
/**
 * (36ms)
 * 这是一个DFS的做法，时间复杂度为O(n^2).它是对每一个节点向下查找和等于sum的路径，找完之后在移动到左右两个子节点。
 * @author Phoenix-Z
 *
 */
public class PathSumIII2 {

	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	public int findPath(TreeNode root, int sum) {
		int res = 0;
		if (root == null)
			return res;
		if (sum == root.val)
			res++;
		res += findPath(root.left, sum - root.val);
		res += findPath(root.right, sum - root.val);
		return res;
	}

}
