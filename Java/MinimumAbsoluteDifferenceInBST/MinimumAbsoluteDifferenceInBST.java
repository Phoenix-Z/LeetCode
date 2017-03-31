import java.util.ArrayList;
import java.util.List;

import com.phoenix.util.TreeNode;
/**
 * (29ms)
 * 中序遍历二叉搜索树可以得到递增的数字序列，然后找到相邻数字差的最小值。
 * @author Phoenix-Z
 *
 */
public class MinimumAbsoluteDifferenceInBST {

	public int getMinimumDifference(TreeNode root) {
        int diff = Integer.MAX_VALUE;
        List<Integer> nums = new ArrayList<>();
        helper(root, nums);
        System.out.println(nums);
        for(int i = 0; i < nums.size() - 1; i++) {
        	if(nums.get(i + 1) - nums.get(i) < diff)
        		diff = nums.get(i + 1) - nums.get(i);
        }
        return diff;
    }
	
	public void helper(TreeNode root, List<Integer> nums) {
		if(root == null)
			return;
		helper(root.left, nums);
		nums.add(root.val);
		helper(root.right, nums);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		MinimumAbsoluteDifferenceInBST2 test = new MinimumAbsoluteDifferenceInBST2();
		System.out.println(test.getMinimumDifference(root));
	}
}
