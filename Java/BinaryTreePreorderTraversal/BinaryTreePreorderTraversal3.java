import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.phoenix.util.TreeNode;
/**
 * (2ms)
 * 这个迭代的写法更加简洁
 * @author Phoenix-Z
 *
 */
public class BinaryTreePreorderTraversal3 {

	public List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> result = new ArrayList<>();
	    if(root == null)
		    return result;
	    Stack<TreeNode> stack = new Stack<>();
	    stack.push(root);
	    while (!stack.isEmpty()) {
	        TreeNode node = stack.pop();
	        result.add(node.val);
	        if(node.right != null) {
	        	stack.push(node.right);
	        }
	        if (node.left != null) {
	        	stack.push(node.left);
	        }
	    }
	    return result;
	}
	
}
