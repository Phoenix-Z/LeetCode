/**
 * (8ms)
 * Created by Phoenix-Z on 2017/4/25.
 */
public class BinaryTreeTilt {

    private int ans = 0;

    public int findTilt(TreeNode root) {
        getSum(root);
        return ans;
    }

    private int getSum(TreeNode root) {
        if(root == null)
            return 0;
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        ans += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
}