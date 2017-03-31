/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
// (165ms)
var getMinimumDifference = function(root) {
    var diff = Number.MAX_SAFE_INTEGER;
    nums = [];
    helper(root, nums);
    for(let i = 0; i < nums.length - 1; i++) {
        if(nums[i + 1] - nums[i] < diff) 
            diff = nums[i + 1] - nums[i];
    }
    return diff;
};

var helper = function(root, nums){
    if(root === null)
        return;
    helper(root.left, nums);
    nums.push(root.val);
    helper(root.right, nums);
};