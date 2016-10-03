import java.util.Stack;

/**
 * (11ms)
 * 迭代的做法，需要借助一个栈。
 * @author Phoenix-Z
 *
 */
public class SumOfLeftLeaves2 {

	public int sumOfLeftLeaves(TreeNode root) {
	    if(root == null) 
	    	return 0;
	    int ans = 0;
	    //这个栈，将遍历过程中遇到的非叶节点压栈
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	    
	    while(!stack.empty()) {
	        TreeNode node = stack.pop();
	        //判断是否存在左子树
	        if(node.left != null) {
	        	//判断是否为叶节点
	            if (node.left.left == null && node.left.right == null)
	                ans += node.left.val;
	            else
	                stack.push(node.left);
	        }
	        //对于右子树而言，需要判断的是它是否有子树，如果有子树就将其入栈
	        if(node.right != null) {
	            if (node.right.left != null || node.right.right != null)
	                stack.push(node.right);
	        }
	    }
	    return ans;
	}
	
}