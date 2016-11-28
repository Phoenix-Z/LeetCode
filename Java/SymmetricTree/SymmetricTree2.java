import java.util.LinkedList;
import java.util.Queue;

/**
 * (2ms)
 * 这是一个迭代的做法，使用队列或者栈都是可以的，使用栈更贴近于递归的概念，使用队列有点类似BFS，
 * 使用哪一种其实最后的实现方法都差不多，关键在于添加到栈或者队列的顺序。
 * @author Phoenix-Z
 *
 */
public class SymmetricTree2 {

	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    q.add(root);
	    while (!q.isEmpty()) {
	        TreeNode t1 = q.poll();
	        TreeNode t2 = q.poll();
	        if (t1 == null && t2 == null) continue;
	        if (t1 == null || t2 == null) return false;
	        if (t1.val != t2.val) return false;
	        q.add(t1.left);
	        q.add(t2.right);
	        q.add(t1.right);
	        q.add(t2.left);
	    }
	    return true;
	}

}