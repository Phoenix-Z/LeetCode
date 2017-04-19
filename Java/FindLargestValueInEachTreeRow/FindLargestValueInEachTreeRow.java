import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

import java.util.*;

/**
 * (10ms)
 * DFS的做法
 * Created by Phoenix-Z on 2017/4/18.
 */
public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        tranverse(root, ans, 0);
        return ans;
    }

    private void tranverse(TreeNode root, List<Integer> rowMax, int level) {
        if(root == null)
            return;
        if(level >= rowMax.size()) {
            rowMax.add(root.val);
        }
        else {
            rowMax.set(level, Math.max(root.val, rowMax.get(level)));
        }
        tranverse(root.left, rowMax, level + 1);
        tranverse(root.right, rowMax, level + 1);
    }

    public static void main(String[] args) {
        FindLargestValueInEachTreeRow test = new FindLargestValueInEachTreeRow();
        TreeNode root = Tree.getTree(new Integer[]{1, 3, 2, 5, 3, null, 9});
        System.out.println(test.largestValues(root));
    }
}
