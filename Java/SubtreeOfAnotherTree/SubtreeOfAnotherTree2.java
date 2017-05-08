import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

/**
 * (33ms)
 * 这个方法是在遍历两棵树的同时将节点的值编码成一个字符串，重点在于添加合适的分隔符。如果不加分隔符，就无法知道字符串中的数字是个位数
 * 还是两位数，也不知道某个节点是否有孩子节点，有几个孩子。一旦损失了这些信息，判断起来就会出错。
 * 当然这个算法依然可以改进，在于java实现的contains方法并没有使用KMP算法，从而导致算法的效率变低。
 * Created by Phoenix-Z on 2017/5/8.
 */
public class SubtreeOfAnotherTree2 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return serialize(s).contains(serialize(t));
    }

    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serialize(root, res);
        return res.toString();
    }

    private void serialize(TreeNode cur, StringBuilder res) {
        if (cur == null) {
            res.append(",#");
            return;
        }
        res.append("," + cur.val);
        serialize(cur.left, res);
        serialize(cur.right, res);
    }

    public static void main(String[] args) {
        TreeNode s = Tree.getTree(new Integer[] {12});
        TreeNode t = Tree.getTree(new Integer[] {2});
        SubtreeOfAnotherTree2 test = new SubtreeOfAnotherTree2();
        System.out.println(test.serialize(s));
        System.out.println(test.serialize(t));
        System.out.println(test.isSubtree(s, t));
    }
}
