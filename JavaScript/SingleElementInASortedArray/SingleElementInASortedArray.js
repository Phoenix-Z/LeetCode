/**
 * (98ms)
 * @param {number[]} nums
 * @return {number}
 */
var singleNonDuplicate = function(nums) {
    var left = 0, right = nums.length / 2;
    while(left < right) {
    	var mid = Math.floor((left + right) / 2);
    	if(nums[2 * mid] != nums[2 * mid + 1]) {
    		right = mid;
    	} else {
    		left = mid + 1;
    	}
    }
    return nums[2 * left];
};