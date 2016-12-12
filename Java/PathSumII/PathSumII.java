import java.util.ArrayList;
import java.util.List;
/**
 * (4ms)
 * 这个方法是通过递归来实现DFS算法。
 * @author Phoenix-Z
 *
 */
public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        helper(root, sum, mid, ans);
        return ans;
    }
	
	public void helper(TreeNode root,int sum,
			List<Integer> mid, List<List<Integer>> ans) {
		if(root == null) 
			return;
		mid.add(root.val);
		if(root.left == null && root.right == null && sum == root.val) {
			//这里很关键，不能写成ans.aa(mid)，因为这只是将mid这个引用添加到了ans中，而随着递归的进行，
			//当时那个引用指向的对象(list)的值已经全部清空了，所以最后呈现出来的是一群空集，
			//因此需要立即生成一个当时那个对象的拷贝添加进去。
			ans.add(new ArrayList<>(mid));
		} else {
			helper(root.left, sum - root.val, mid, ans);
			helper(root.right, sum - root.val, mid, ans);
		}
		//遍历完左右子树，返回到上一层时，需要删除当前节点的值，否则所有节点的值都会加入到mid中。
		mid.remove(mid.size() - 1);
	}
	
}

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}