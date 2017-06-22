/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * (172ms)
 * @param {TreeNode} root
 * @param {number} v
 * @param {number} d
 * @return {TreeNode}
 */
var addOneRow = function(root, v, d) {
    if(d == 1) {
    	var newRoot = new TreeNode(v);
    	newRoot.left = root;
    	return newRoot;
    } else {
    	dfs(root, v, d, 1);
    	return root;
    }
};

var dfs = function(root, v, d, level) {
	if(root == null || level >= d)
		return;
	if(level == d - 1) {
		var newLeft = new TreeNode(v), newRight = new TreeNode(v);
		newLeft.left = root.left;
		newRight.right = root.right;
		root.left = newLeft;
		root.right = newRight;
	} else {
		dfs(root.left, v, d, level + 1);
		dfs(root.right, v, d, level + 1);
	}
};