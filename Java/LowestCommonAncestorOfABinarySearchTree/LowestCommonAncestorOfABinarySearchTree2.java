import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

/**
 * (24ms)
 * 这个方法效率很低，就是从根节点开始依次往下遍历整棵树，如果给定的p和q节点均是当前节点的孩子，就更新该节点为公共父节点。
 * 思路简单清晰，时间复杂度为O(n^2).
 * Created by Phoenix-Z on 2017/4/15.
 */
public class LowestCommonAncestorOfABinarySearchTree2 {

    private TreeNode ancestor = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(isChild(root, p) && isChild(root, q))
            ancestor = root;
        lowestCommonAncestor(root.left, p, q);
        lowestCommonAncestor(root.right, p, q);
        return ancestor;
    }

    public boolean isChild(TreeNode root, TreeNode target) {
        return root == target || (root != null && (isChild(root.left, target) || isChild(root.right, target)));
    }

    public static void main(String[] args) {
        Integer[] values = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = Tree.getTree(values);
        LowestCommonAncestorOfABinarySearchTree2 test = new LowestCommonAncestorOfABinarySearchTree2();
        System.out.println(test.lowestCommonAncestor(root, root.left, root.left.right).val);
    }

}
