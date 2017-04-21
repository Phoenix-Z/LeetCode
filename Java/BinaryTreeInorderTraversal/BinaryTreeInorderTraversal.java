import com.phoenix.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * (1ms)
 * Created by Phoenix-Z on 2017/4/21.
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans) {
        if(root == null)
            return;
        helper(root.left, ans);
        ans.add(root.val);
        helper(root.right, ans);
    }

}
