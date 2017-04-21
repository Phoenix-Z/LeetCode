/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * (112ms)
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
    var ans = [];
    var stack = [];
    var cur = root;
    while(cur !== null || stack.length > 0) {
        while(cur !== null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        ans.push(cur.val);
        cur = cur.right;
    }
    return ans;
};