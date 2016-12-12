import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * (6ms)
 * 这个方法是通过迭代的方式实现DFS算法。
 * @author Phoenix-Z
 *
 */
public class PathSumII2 {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		//stack用来存储访问过的节点
		Stack<TreeNode> stack = new Stack<TreeNode>();
		//now表示从根节点到当前节点的val的总和
		int now = 0;
		
		//cur指向当前节点，pre指向当前节点的前一个节点
		TreeNode cur = root;
		TreeNode pre = null;
		
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				path.add(cur.val);
				now += cur.val;
				cur = cur.left;
			}
			cur = stack.peek();
			if (cur.right != null && cur.right != pre) {
				cur = cur.right;
				continue;
			}
			if (cur.left == null && cur.right == null && now == sum)
				res.add(new ArrayList<Integer>(path));

			pre = cur;
			stack.pop();
			path.remove(path.size() - 1);
			now -= cur.val;
			cur = null;

		}
		return res;
	}

}