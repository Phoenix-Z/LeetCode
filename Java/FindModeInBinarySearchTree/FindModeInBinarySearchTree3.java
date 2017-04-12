import com.phoenix.Util.TreeNode;

/**
 * (6ms)
 * 这个方法可能才是真正意义上的O(1)空间复杂度的算法。这其实就是对第一个解法的优化，这个算法进行了两次中序遍历，第一次遍历是
 * 为了找出数字出现最多的次数m，以及有多少个数字出现了m次，从而可以确定数组的长度。第二次遍历就是为了找出出现了m次的数字。
 * Created by Phoenix-Z on 2017/4/12.
 */
public class FindModeInBinarySearchTree3 {

    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }

    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;

    private int[] modes;

    private void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            // 这里的判断是为了第二次遍历，对第一次遍历不起作用
            if (modes != null)
                modes[modeCount] = currVal;
            modeCount++;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }

    // 以下是morris traversal 可以替代上述的inorder方法，可以减少栈空间的使用
    private void morrisTraversal(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                handleValue(node.val);
                node = node.right;
            } else {
                TreeNode prev = node.left;
                while (prev.right != null && prev.right != node)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    handleValue(node.val);
                    node = node.right;
                }
            }
        }
    }
}
