import com.phoenix.Util.Tree;
import com.phoenix.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * (26ms)
 * 层次遍历
 * Created by Phoenix-Z on 2017/6/14.
 */
public class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> nodes = new LinkedList<>();
        if(root != null) {
            nodes.offer(root);
            str.append(root.val + "#");
        }
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.poll();
            if(cur.left != null) {
                nodes.offer(cur.left);
                str.append(cur.left.val + "#");
            }
            if(cur.left == null) {
                str.append('#');
            }
            if(cur.right != null) {
                nodes.offer(cur.right);
                str.append(cur.right.val + "#");
            }
            if(cur.right == null) {
                str.append('#');
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        String[] valuesInStr = data.split("#");
        Integer[] values = new Integer[valuesInStr.length];
        for (int i = 0; i < valuesInStr.length; i++) {
            if(!valuesInStr[i].equals("")) {
                values[i] = Integer.parseInt(valuesInStr[i]);
            } else {
                values[i] = null;
            }
        }
        TreeNode root = null;
        if(values.length > 0)
            root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(i < values.length) {
            TreeNode now = queue.poll();
            if(now == null)
                continue;
            if(values[i] == null)
                now.left = null;
            else
                now.left = new TreeNode(values[i]);
            queue.offer(now.left);
            i++;
            if(i >= values.length)
                break;
            if(values[i] == null)
                now.right = null;
            else
                now.right = new TreeNode(values[i]);
            i++;
            queue.offer(now.right);
        }
        return root;
    }

    public void display(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val);
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = Tree.getTree(new Integer[] {1, 2, 3, null, 4});
        SerializeAndDeserializeBST test = new SerializeAndDeserializeBST();
        String ans = test.serialize(root);
        System.out.println(ans);
        TreeNode newRoot = test.deserialize(ans);
        test.display(newRoot);

    }
}
