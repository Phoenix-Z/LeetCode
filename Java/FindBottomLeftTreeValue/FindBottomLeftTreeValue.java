import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * (9ms)
 * Created by Phoenix-Z on 2017/4/20.
 */
public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> treeVal = new ArrayList<>();
        traverse(root, treeVal, 0);
        return treeVal.get(treeVal.size() - 1).get(0);
    }

    private void traverse(TreeNode root, List<List<Integer>> treeVal, int level) {
        if(root == null)
            return;
        if(level >= treeVal.size()) {
            List<Integer> now = new ArrayList<>();
            now.add(root.val);
            treeVal.add(now);
        } else {
            treeVal.get(level).add(root.val);
        }
        traverse(root.left, treeVal, level + 1);
        traverse(root.right, treeVal, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = Tree.getTree(new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7});
        FindBottomLeftTreeValue test = new FindBottomLeftTreeValue();
        System.out.println(test.findBottomLeftValue(root));
    }

}
