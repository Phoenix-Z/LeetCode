import com.phoenix.Util.TreeNode;

/**
 * (42ms)
 * 更简洁些。
 * Created by Phoenix-Z on 2017/6/4.
 */
public class ConstructStringFromBinaryTree2 {

    public String tree2str(TreeNode t) {
        if (t == null)
            return "";

        String result = t.val + "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left == "" && right == "") return result;
        if (left == "") return result + "()" + "(" + right + ")";
        if (right == "") return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }
}
