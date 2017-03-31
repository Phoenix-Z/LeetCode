import com.phoenix.util.TreeNode;
/**
 * (20ms)
 * 这是对方法一的改进，没有必要保存遍历的数字，在遍历的同时找到最小数字差即可。
 * @author Phoenix-Z
 *
 */
public class MinimumAbsoluteDifferenceInBST2 {

	private int diff = Integer.MAX_VALUE;
	private Integer prev = null;

	public int getMinimumDifference(TreeNode root) {
        if (root == null) {
			return diff;
		}
        getMinimumDifference(root.left);
        if (prev != null) {
        	diff = Math.min(diff, root.val - prev);
		}
        prev = root.val;
        getMinimumDifference(root.right);
        return diff;
    }
	
}
