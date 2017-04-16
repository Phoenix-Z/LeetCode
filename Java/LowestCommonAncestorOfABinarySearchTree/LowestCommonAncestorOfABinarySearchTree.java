import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

import java.util.*;

/**
 * (29ms)
 * 这个方法首先是分别找到root到p和q的各自的路径，用String保存下来，然后根据这两个String找到最后一个共有的数字，再将其返回。
 * Created by Phoenix-Z on 2017/4/11.
 */
public class LowestCommonAncestorOfABinarySearchTree {

    private String pPath = null;
    private String qPath = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, "", p, 0);
        helper(root, "", q, 1);
        Set<String> valInQPath = new HashSet<>(Arrays.asList(qPath.split(" ")));
        String[] valInPPath = pPath.split(" ");
        int i;
        for(i = valInPPath.length - 1; i>= 0; i--) {
            if (valInQPath.contains(valInPPath[i]))
                break;
        }
        TreeNode ans = new TreeNode(Integer.parseInt(valInPPath[i]));
        System.out.println(pPath);
        System.out.println(qPath);
        return ans;
    }

    private void helper(TreeNode root, String path, TreeNode target, int flag) {
        if(root == null)
            return;
        if(root == target) {
            path += root.val;
            if(flag == 0)
                pPath = path;
            else
                qPath = path;
            return;
        }
        path += root.val + " ";
        helper(root.left, path, target, flag);
        helper(root.right, path, target, flag);
    }

    public static void main(String[] args) {
        Integer[] values = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = Tree.getTree(values);
        LowestCommonAncestorOfABinarySearchTree test = new LowestCommonAncestorOfABinarySearchTree();
        System.out.println(test.lowestCommonAncestor(root, root.left.right, root.right.left).val);
    }

}
