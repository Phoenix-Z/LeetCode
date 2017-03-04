/**
 * @param {number[]} nums
 * @return {number}
 */
// (106ms)
// binary search method
var findDuplicate = function(nums) {
    if(!nums || nums.length < 2) {
        return -1;
    }
    var left = 0, right = nums.length;
    while(left < right) {
        let mid = Math.floor((left + right) / 2), count = 0;
        nums.forEach(function(item) {
            if(item <= mid)
                count++;
        });
        if(count > mid) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
};

// (89ms)
// linked list cycle method
var findDuplicate2 = function(nums) {
    if(!nums || nums.length < 2) {
        return -1;
    }
    var slow = nums[0];
    var fast = nums[nums[0]];
    while(slow != fast) {
        slow = nums[slow];
        fast = nums[nums[fast]];
    }
    fast = 0;
    while(slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
    }
    return slow;
};