/**
 * @param {number[]} nums
 * @return {boolean}
 */
// (315ms)
var PredictTheWinner = function(nums) {
    return helper(nums, 0, nums.length - 1) >= 0;
};

var helper = function(nums, left, right) {
    return left == right ? nums[left] : Math.max(nums[left] - helper(nums, left + 1, right), nums[right] - helper(nums, left, right -1));
}