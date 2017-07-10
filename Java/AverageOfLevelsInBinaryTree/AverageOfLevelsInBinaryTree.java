import com.phoenix.Util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (14ms)
 * 这个方法先遍历整棵树，保存每一层的数字，然后再计算平均值。当然比较快捷且节省空间的方法是层次遍历这棵树。
 * Created by Phoenix-Z on 2017/7/10.
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<Integer>> nums = new HashMap<>();
        travesal(root, nums, 0);
        List<Double> ans = new ArrayList<>(nums.size());
        for(int i = 0; i < nums.size(); i++) {
            double sum = 0;
            for(int num : nums.get(i)) {
                sum += num;
            }
            ans.add(sum / nums.get(i).size());
        }
        return ans;
    }

    private void travesal(TreeNode root, Map<Integer, List<Integer>> nums, int level) {
        if(root == null)
            return;
        List<Integer> values = nums.get(level);
        if(values == null) {
            values = new ArrayList<>();
            nums.put(level, values);
        }
        values.add(root.val);
        travesal(root.left, nums, level + 1);
        travesal(root.right, nums, level + 1);
    }

}
