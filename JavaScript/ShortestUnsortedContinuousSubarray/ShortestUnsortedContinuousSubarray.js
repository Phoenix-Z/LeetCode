/**
 * (148ms)
 * @param {number[]} nums
 * @return {number}
 */
var findUnsortedSubarray = function(nums) {
    var begin = -1, end = -2, n = nums.length;
    var min = nums[n - 1], max = nums[0];
    for(var i = 1; i < n; i++) {
    	max = Math.max(max, nums[i]);
    	min = Math.min(min, nums[n - 1 - i]);
    	if(max > nums[i])
    		end = i;
    	if(min < nums[n - 1 - i]) 
    		begin = n - 1 - i;
    }
    return end - begin + 1;
};