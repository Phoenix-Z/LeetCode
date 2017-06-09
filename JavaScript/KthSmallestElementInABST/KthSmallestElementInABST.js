/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * (158ms)
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(root, k) {
    var count = [];
    dfs(root, count, k);
    return count[k-1];
};

var dfs = function(root, now, k) {
	if(root === null || now.length === k)
		return;
	dfs(root.left, now, k);
	now.push(root.val);
	dfs(root.right, now, k);
};