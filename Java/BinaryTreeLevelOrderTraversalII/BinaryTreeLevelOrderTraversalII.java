import com.phoenix.Util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (4ms)
 * 其实不使用Map也是可以的，这里只是为了看起来更好理解。这是个DFS的解法。
 * Created by Phoenix-Z on 2017/4/10.
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        helper(root, map, 1);
        List<List<Integer>> ans = new ArrayList<>(map.size());
        for(int i = 0; i < map.size(); i++) {
            ans.add(map.get(map.size() - i));
        }
        return ans;
    }

    private void helper(TreeNode root, Map<Integer, List<Integer>> map, int level) {
        if(root == null)
            return;
        List<Integer> now = map.get(level);
        if(now == null)
            now = new ArrayList<>();
        now.add(root.val);
        map.put(level, now);
        helper(root.left, map, level + 1);
        helper(root.right, map, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BinaryTreeLevelOrderTraversalII test = new BinaryTreeLevelOrderTraversalII();
        System.out.println(test.levelOrderBottom(root));
    }

}
