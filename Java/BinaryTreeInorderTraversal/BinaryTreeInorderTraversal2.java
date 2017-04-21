import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

import java.util.*;

/**
 * (1ms)
 * Created by Phoenix-Z on 2017/4/21.
 */
public class BinaryTreeInorderTraversal2 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = Tree.getTree(new Integer[]{1, null, 2, 3});
        System.out.println(inorderTraversal(root));
    }
}
