/**
 * Created by Phoenix-Z on 2017/5/3.
 */
/**
 * (118ms)
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    var helper = function (ans, now, nums, pos) {
        ans.push(now.slice());
        for(var i = pos; i < nums.length; i++) {
            now.push(nums[i]);
            helper(ans, now, nums, i + 1);
            now.pop();
        }
    };
    var ans = [];
    helper(ans, [], nums, 0);
    return ans;
};