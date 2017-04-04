import java.util.ArrayList;
import java.util.List;

import com.phoenix.util.TreeNode;
/**
 * (1ms)
 * 递归的做法
 * @author Phoenix-Z
 *
 */
public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		helper(root, ans);
		return ans;
    }
	
	public void helper(TreeNode root, List<Integer> nums) {
		if(root == null)
			return;
		nums.add(root.val);
		helper(root.left, nums);
		helper(root.right, nums);
	}
	
}
