/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
// (95ms) recursive
var preorderTraversal = function(root) {
    var helper = function(root, nums){
        if(root === null)
            return;
        nums.push(root.val);
        helper(root.left, nums);
        helper(root.right, nums);
    }
    var ans = [];
    helper(root, ans);
    return ans;
};

// (106ms) iterative
var preorderTraversal = function(root) {
    var stack = [];
    stack.push(root);
    var ans = [];
    while(stack.length > 0) {
        root = stack.pop();
        if(root !== null) {
            ans.push(root.val);
            stack.push(root.right);
            stack.push(root.left);
        }
    }
    return ans;
};