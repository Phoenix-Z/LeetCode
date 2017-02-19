/**
 * @param {number[]} nums
 * @return {number[]}
 */
// (259ms)
var nextGreaterElements = function(nums) {
    stack = [];
    ans = Array(nums.length).fill(-1);
    for(let i = 0; i < nums.length * 2; i++) {
        while(Array.length > 0 && nums[stack[stack.length - 1]] < nums[i % nums.length]) {
            ans[stack.pop()] = nums[i % nums.length];
        }
        if(i < nums.length) {
            stack.push(i);
        }
    }
    return ans;
};