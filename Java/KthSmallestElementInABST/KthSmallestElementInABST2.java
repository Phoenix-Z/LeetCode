import com.phoenix.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * (4ms)
 * 最简单的做法
 * Created by Phoenix-Z on 2017/6/8.
 */
public class KthSmallestElementInABST2 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        DFS(root, values, k);
        return values.get(k - 1);
    }

    private void DFS(TreeNode root, List<Integer> now, int k) {
        if(root == null || now.size() == k)
            return;
        DFS(root.left, now, k);
        now.add(root.val);
        DFS(root.right, now, k);
    }


}
