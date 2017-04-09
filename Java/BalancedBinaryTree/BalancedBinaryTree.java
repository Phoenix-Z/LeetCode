import com.phoenix.Util.TreeNode;

/**
 * (2ms)
 * Created by Phoenix-Z on 2017/4/9.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
