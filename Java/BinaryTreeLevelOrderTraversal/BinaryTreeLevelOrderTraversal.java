import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * (1ms)
 * 深度优先遍历
 * Created by Phoenix-Z on 2017/5/11.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        DFS(ans, root, 0);
        return ans;
    }

    private void DFS(List<List<Integer>> ans, TreeNode root, int level) {
        if(root == null)
            return;
        if(ans.size() <= level) {
            ans.add(new ArrayList<>());
        }
        List<Integer>now = ans.get(level);
        now.add(root.val);
        DFS(ans, root.left, level + 1);
        DFS(ans, root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = Tree.getTree(new Integer[] {3, 9, 20, null, null, 15, 7});
        BinaryTreeLevelOrderTraversal test = new BinaryTreeLevelOrderTraversal();
        System.out.println(test.levelOrder(root));
    }
}
