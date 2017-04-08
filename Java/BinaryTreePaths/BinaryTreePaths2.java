import com.phoenix.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * (18ms)
 * 这个方法使用StringBuilder替代String，与String不同的是，需要删除每一层递归添加的字符。
 * Created by Phoenix-Z on 2017/4/8.
 */
public class BinaryTreePaths2 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root != null)
            helper(root, ans, new StringBuilder());
        return ans;
    }

    private void helper(TreeNode root, List<String> ans, StringBuilder now) {
        int oldLen = now.length();
        if(root.left == null && root.right == null) {
            ans.add(now.append(root.val).toString());
        } else {
            now.append(root.val).append("->");
            if (root.left != null)
                helper(root.left, ans, now);
            if (root.right != null)
                helper(root.right, ans, now);
        }
        now.delete(oldLen, now.length());
    }

}
