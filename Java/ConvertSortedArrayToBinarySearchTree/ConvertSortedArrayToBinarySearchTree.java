import com.phoenix.util.TreeNode;
/**
 * (1ms)
 * 这个题目不仅仅是要将一个排序好的数组转换成一个二叉搜索树，而且这个BST还得是平衡的。可以每次选取数组中间的值作为根节点，
 * 该节点的左子树由左半部分数组中的数字构造，右子树由右半部分数组中的数字构造，递归处理即可。
 * @author Phoenix-Z
 *
 */
public class ConvertSortedArrayToBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length == 0) 
			return null;
		TreeNode root = helper(nums, 0, nums.length - 1);
        return root;
    }

	private TreeNode helper(int[] nums, int left, int right) {
		if(left == right)
			return new TreeNode(nums[left]);
		if(left > right)
			return null;
		int mid = (left + right + 1) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);
		return root;
	}
	
}
