import com.phoenix.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * (17ms)
 * Created by Phoenix-Z on 2017/4/8.
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root != null)
            helper(root, ans, "");
        return ans;
    }

    private void helper(TreeNode root, List<String> ans, String now) {
        if(root.left == null && root.right == null) {
            ans.add(now + root.val);
            return;
        }
        now += root.val + "->";
        if(root.left != null)
            helper(root.left, ans, now);
        if(root.right != null)
            helper(root.right, ans, now);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        BinaryTreePaths2 test = new BinaryTreePaths2();
        System.out.println(test.binaryTreePaths(root));
    }
}
