import java.util.HashMap;

import com.phoenix.util.TreeNode;
/**
 * (19ms)
 * 这个方法很巧妙，这里面使用了一个HashMap，它的键是遍历到当前节点之前的前缀和，值是有多少种途径获取到这个键。
 * 这个方法有个很重要的部分，就是中间节点(root到当前节点的中间)到当前节点的路径和，等于root到当前节点的路径和减去root到
 * 中间节点的路径和，而root到中间节点的路径和已经在到达当前节点之间放入到map中了。
 * 所以target = currSum - preSum，也即preSum = currSum - target，以此访问map即可。
 * @author Phoenix-Z
 *
 */
public class PathSumIII {


	public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }
    
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        // 加上当前节点的值以更新当前和
        currSum += root.val;
        // 找到以当前节点为尾的合理路径的个数
        int res = preSum.getOrDefault(currSum - target, 0);
        // 更新map，以便可以传到下一层递归
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        // 加上三个部分的个数和:
        // 1. 以当前节点为尾节点的路径
        // 2. 以当前节点为根节点的左子树所有路径
        // 3. 以当前节点为根节点的右子树所有路径
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        // 把当前节点的值去掉，以方便退回到上一层递归
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.right.right = new TreeNode(11);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right.right = new TreeNode(1);
		PathSumIII test = new PathSumIII();
		System.out.println(test.pathSum(root, 8));
	}
}
