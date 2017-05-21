/**
 * (118ms)
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
	var numOfZero = 0, numOfOne = 0, numOfTwo = 0;
    for(var num of nums) {
    	if(num == 0) {
    		numOfZero++;
    	} else if(num == 1) {
    		numOfOne++;
    	} else {
    		numOfTwo++;
    	}
    }
    for(var i = 0; i < numOfZero; i++) {
    	nums[i] = 0;
    }
    for(var i = 0; i < numOfOne; i++) {
    	nums[i + numOfZero] = 1;
    }
    for(var i = 0; i < numOfZero; i++) {
    	nums[i + numOfZero + numOfOne] = 2;
    }
};