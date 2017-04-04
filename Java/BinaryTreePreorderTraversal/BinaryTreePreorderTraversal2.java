import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.phoenix.util.TreeNode;
/**
 * (1ms)
 * 迭代的做法
 * @author Phoenix-Z
 *
 */
public class BinaryTreePreorderTraversal2 {

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if(root == null)
			return ans;
		Stack<TreeNode> stack = new Stack<>();
		ans.add(root.val);
		stack.add(root);
		while(!stack.isEmpty()) {
			if(root.left != null) {
				root = root.left;
				ans.add(root.val);
				stack.add(root);
				continue;
			}
			
			root = stack.pop();
			root.left = null;
			
			if(root.right != null) {
				root = root.right;
				ans.add(root.val);
				stack.add(root);
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		System.out.println(preorderTraversal(root));
	}
}
