import com.phoenix.Util.TreeNode;

import java.util.*;

/**
 * (31ms)
 * 这个方法相较于第一个方法，减少了递归了次数，进而避免了一些不必要的重复计算。
 * Created by Phoenix-Z on 2017/4/23.
 */
public class MostFrequentSubtreeSum2 {

    private Map<Integer, Integer> count = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null)
            return new int[0];
        traverse(root);
        int maxCount = 0;
        for(int countNum : count.values()) {
            if(maxCount < countNum)
                maxCount = countNum;
        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if(entry.getValue() == maxCount)
                res.add(entry.getKey());
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private int traverse(TreeNode root) {
        if(root == null)
            return 0;
        int sum = root.val + traverse(root.left) + traverse(root.right);
        count.put(sum, count.getOrDefault(sum, 0) + 1);
        return sum;
    }

}
