import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

import java.util.*;

/**
 * (37ms)
 * 这个解法思路很简单粗暴，效率也较低。
 * Created by Phoenix-Z on 2017/4/23.
 */
public class MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> count = new HashMap<>();
        traverse(root, count);
        TreeMap<Integer, List<Integer>> map= new TreeMap<>();
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int val = entry.getValue();
            List<Integer> now = map.get(val);
            if(now == null)
                now = new ArrayList<>();
            now.add(entry.getKey());
            map.put(val, now);
        }
        List<Integer> res = root != null ? map.lastEntry().getValue() : new ArrayList<>();
        int[] ans = new int[res.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void traverse(TreeNode root, Map<Integer, Integer> count) {
        if(root == null)
            return;
        int sum = root.val + getSum(root.left) + getSum(root.right);
        count.put(sum, count.getOrDefault(sum, 0) + 1);
        traverse(root.left, count);
        traverse(root.right, count);
    }

    private int getSum(TreeNode root) {
        if(root == null)
            return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = Tree.getTree(new Integer[] {5, 2, -3});
        MostFrequentSubtreeSum2 test = new MostFrequentSubtreeSum2();
        System.out.println(Arrays.toString(test.findFrequentTreeSum(root)));
    }

}
