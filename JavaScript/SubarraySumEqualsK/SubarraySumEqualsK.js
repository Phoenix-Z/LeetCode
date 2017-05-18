/**
 * (299ms)
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function(nums, k) {
    var count = 0, nowSum = 0;
    var prevSum = new Map();
    prevSum.set(0, 1);
    for(var num of nums) {
    	nowSum += num;
    	if(prevSum.has(nowSum - k)) {
    		count += prevSum.get(nowSum - k);
    	}
    	if(prevSum.has(nowSum)) {
    		prevSum.set(nowSum, prevSum.get(nowSum) + 1);
    	} else {
    		prevSum.set(nowSum, 1);
    	}
    } 
    return count;
};