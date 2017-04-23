import com.phoenix.Util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * （17ms）
 * 这个方法相较于方法二而言，只是将maxCount的统计变成了拿到了全局变量，在一边递归的时候一边更新maxCount，而不是递归完成后
 * 再次遍历Map，效率提高明显。
 * Created by Phoenix-Z on 2017/4/23.
 */
public class MostFrequentSubtreeSum3 {

    private Map<Integer, Integer> count = new HashMap<>();
    private int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null)
            return new int[0];
        traverse(root);
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
        int nowCount = count.getOrDefault(sum, 0) + 1;
        count.put(sum, nowCount);
        maxCount = Math.max(maxCount, nowCount);
        return sum;
    }

}
