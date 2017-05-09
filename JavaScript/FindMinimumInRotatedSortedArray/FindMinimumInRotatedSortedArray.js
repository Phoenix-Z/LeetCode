/**
 * (136ms)
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    var left = 0, right = nums.length - 1;
    while(left < right) {
		// javascript 没有整除
        var mid = Math.floor(left + (right - left) / 2);
        if(nums[mid] < nums[right]) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    console.log(left);
    return nums[left];
};