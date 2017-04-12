import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (6ms)
 * 这个解法就是充分利用了中序遍历一棵BST，就是根据树中节点的val值从小到大遍历。当然这个解法的空间复杂度依然不是O(1)的。
 * Created by Phoenix-Z on 2017/4/12.
 */
public class FindModeInBinarySearchTree {

    private int maxTimes = 0;
    private int nowTimes = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        helper(root, ans);

        if(nowTimes < maxTimes) {
            ans.remove(ans.size() - 1);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void helper(TreeNode root, List<Integer> ans) {
        if(root == null)
            return;
        helper(root.left, ans);
        if(ans.isEmpty()) {
            ans.add(root.val);
            nowTimes = 1;
            maxTimes = Math.max(nowTimes, maxTimes);
        } else {
            if(ans.get(ans.size() - 1).equals(root.val)) {
                nowTimes++;
                if(nowTimes > maxTimes) {
                    ans.clear();
                    ans.add(root.val);
                    maxTimes = nowTimes;
                }
            } else {
                if(nowTimes < maxTimes) {
                    ans.remove(ans.size() - 1);
                }
                ans.add(root.val);
                nowTimes = 1;
            }
        }
        helper(root.right, ans);
    }

    public static void main(String[] args) {
        TreeNode root = Tree.getTree(new Integer[]{1,null,2,2});
        FindModeInBinarySearchTree test = new FindModeInBinarySearchTree();
        System.out.println(Arrays.toString(test.findMode(root)));
    }

}
