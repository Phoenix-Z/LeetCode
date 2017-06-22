import com.phoenix.Util.TreeNode;

/**
 * (8ms)
 * Created by Phoenix-Z on 2017/6/20.
 */
public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        } else {
            add(root, v, d, 1);
            return root;
        }
    }

    private void add(TreeNode root, int v, int d, int level) {
        if(root == null || level >= d)
            return;
        if(level == d - 1) {
            TreeNode newLeft = new TreeNode(v);
            TreeNode newRight = new TreeNode(v);
            newLeft.left = root.left;
            newRight.right = root.right;
            root.left = newLeft;
            root.right = newRight;
        } else {
            add(root.left, v, d, level + 1);
            add(root.right, v, d, level + 1);
        }
    }

}
