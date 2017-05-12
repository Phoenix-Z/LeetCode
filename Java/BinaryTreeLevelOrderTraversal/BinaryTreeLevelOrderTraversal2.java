import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * (2ms)
 * 广度优先搜索
 * Created by Phoenix-Z on 2017/5/11.
 */
public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> now = new ArrayList<>();
            int size = queue.size();
            while(0 < size--) {
                TreeNode cur = queue.poll();
                now.add(cur.val);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            ans.add(now);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = Tree.getTree(new Integer[] {3, 9, 20, null, null, 15, 7});
        BinaryTreeLevelOrderTraversal2 test = new BinaryTreeLevelOrderTraversal2();
        System.out.println(test.levelOrder(root));
    }
}
