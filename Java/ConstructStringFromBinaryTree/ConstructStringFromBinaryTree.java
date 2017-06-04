import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

/**
 * (45ms)
 * Created by Phoenix-Z on 2017/6/4.
 */
public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode t) {
        StringBuilder ans = new StringBuilder();
        preorder(t, ans);
        return ans.toString();
    }

    private void preorder(TreeNode now, StringBuilder ans) {
        if(now == null) {
            return;
        }
        ans.append(now.val);
        StringBuilder leftPart = new StringBuilder(), rightPart = new StringBuilder();
        leftPart.append('(');
        preorder(now.left, leftPart);
        leftPart.append(')');
        rightPart.append('(');
        preorder(now.right, rightPart);
        rightPart.append(')');
        ans.append(leftPart);
        ans.append(rightPart);
        while(ans.lastIndexOf("()") == ans.length() - 2 && ans.lastIndexOf("()") >= 0) {
            ans.setLength(ans.length() - 2);
        }
    }

    public static void main(String[] args) {
        TreeNode root = Tree.getTree(new Integer[] {1});
        ConstructStringFromBinaryTree test = new ConstructStringFromBinaryTree();
        System.out.println(test.tree2str(root));
    }

}
