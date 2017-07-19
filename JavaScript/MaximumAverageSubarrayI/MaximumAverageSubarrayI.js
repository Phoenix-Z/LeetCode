/**
 * (168ms)
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    var now = 0;
    for(let i = 0; i < k; i++) {
    	now += nums[i];
    }
    var max = now, head = k, tail = 0;
    while(head < nums.length) {
    	now = now - nums[tail++] + nums[head++];
    	max = Math.max(max, now);
    }
    return max / k;
};