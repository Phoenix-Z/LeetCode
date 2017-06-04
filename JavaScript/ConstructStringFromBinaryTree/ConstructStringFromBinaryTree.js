/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * (159ms)
 * @param {TreeNode} t
 * @return {string}
 */
var tree2str = function(t) {
    if(t == null)
    	return '';
    var left = tree2str(t.left), right = tree2str(t.right);
    if(left === '' && right === '')
    	return t.val + '';
    return t.val + '(' + left + ')' + (right === '' ? '' : '(' + right + ')');
};