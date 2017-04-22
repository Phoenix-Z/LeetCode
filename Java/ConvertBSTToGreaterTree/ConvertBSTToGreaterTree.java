import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

/**
 * (22ms)
 * Created by Phoenix-Z on 2017/4/21.
 */
public class ConvertBSTToGreaterTree {

    private int prevSum = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if(root == null)
            return;
        traverse(root.right);
        root.val += prevSum;
        prevSum = root.val;
        traverse(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = Tree.getTree(new Integer[]{5, 2, 13});
        Tree.printTree(root);
        System.out.println();
        ConvertBSTToGreaterTree test = new ConvertBSTToGreaterTree();
        Tree.printTree(test.convertBST(root));
        System.out.println();
    }
}
