import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * (3ms)
 * BFS即可。
 * Created by Phoenix-Z on 2017/7/11.
 */
public class BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode now = queue.poll();
                    if (now.left != null)
                        queue.add(now.left);
                    if (now.right != null)
                        queue.add(now.right);
                    if (i == size - 1)
                        ans.add(now.val);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = Tree.getTree(new Integer[]{1, 2, 3, null, 4, null, 5});
        System.out.println(rightSideView(root));
    }
}
