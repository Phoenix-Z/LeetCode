import com.phoenix.Util.TreeNode;

import java.util.*;

/**
 * (20ms)
 * 这个方法是借助了Map这个数据结构，在遍历树的同时记录每个数字出现的次数，然后在用另一个Map，以出现的次数为键，出现次数相同
 * 的数字组成一个List，最后进行List到数组的转换。正确性不言而喻，效率相对较低。
 * Created by Phoenix-Z on 2017/4/12.
 */
public class FindModeInBinarySearchTree2 {

    public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[0];
        Map<Integer, Integer> counter = new HashMap<>();
        helper(root, counter);
        TreeMap<Integer, List<Integer>> times = new TreeMap<>();
        for(Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            List<Integer> now = times.get(entry.getValue());
            if(now == null)
                now = new ArrayList<>();
            now.add(entry.getKey());
            times.put(entry.getValue(), now);
        }
        List<Integer> ansList = times.lastEntry().getValue();
        int[] ans = new int[ansList.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    private void helper(TreeNode root, Map<Integer, Integer> counter) {
        if(root == null)
            return;
        counter.put(root.val, counter.getOrDefault(root.val, 0) + 1);
        helper(root.left, counter);
        helper(root.right, counter);
    }

}
