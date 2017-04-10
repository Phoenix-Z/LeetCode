import com.phoenix.Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * （3ms）
 * 这是一个BFS的做法。
 * Created by Phoenix-Z on 2017/4/10.
 */
public class BinaryTreeLevelOrderTraversalII2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }

}
