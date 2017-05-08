import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

/**
 * (27ms)
 * 这个方法是遍历s树中的每一个点，然后调用子函数isSame来判断以当前点为根节点的子树是否与树t相同。
 * Created by Phoenix-Z on 2017/5/8.
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return false;
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(s.val != t.val)
            return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode s = Tree.getTree(new Integer[] {3, 4, 5, 1, 2, null, null, null, null, 0});
        TreeNode t = Tree.getTree(new Integer[] {4, 1, 2});
        SubtreeOfAnotherTree test = new SubtreeOfAnotherTree();
        System.out.println(test.isSubtree(s, t));
    }

}
