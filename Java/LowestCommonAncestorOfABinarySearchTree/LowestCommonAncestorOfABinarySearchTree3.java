import com.phoenix.Util.TreeNode;

/**
 * 这个解法充分利用了BST的性质，如果当前节点的值介于p和q之间，那就意味着p和q分局于当前的左右子树中，那么当前节点就是LCA，
 * 停止向下遍历。如果p和q同时大于或者小于当前节点的值，就意味着p和q同时位于当前节点的左子树或者右子树，然后更新当前节点为
 * 左子树或者右子树的根节点即可。时间复杂度为树高。
 * Created by Phoenix-Z on 2017/4/15.
 */
public class LowestCommonAncestorOfABinarySearchTree3 {

    // (11ms) 迭代的做法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }

    // (8ms) 递归的做法
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        return (root.val - p.val) * (root.val - q.val) < 1 ? root :
                lowestCommonAncestor2(p.val < root.val ? root.left : root.right, p, q);
    }
}
