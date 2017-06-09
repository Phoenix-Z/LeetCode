import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * (4ms)
 * 迭代的做法
 * Created by Phoenix-Z on 2017/6/8.
 */
public class KthSmallestElementInABST {

    public static int kthSmallest(TreeNode root, int k) {
        int target = root.val;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        while(k-- > 0) {
            TreeNode cur = stack.pop();
            while(cur.left != null && !visited.contains(cur)) {
                visited.add(cur);
                stack.push(cur);
                cur = cur.left;
            }
            target = cur.val;
            if(cur.right != null)
                stack.push(cur.right);
        }
        return target;
    }

    public static void main(String[] args) {
        TreeNode root = Tree.getTree(new Integer[]{2, 1});
        System.out.println(kthSmallest(root, 2));
    }

}
