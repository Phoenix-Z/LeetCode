/**
 * @param {number[]} nums
 * @return {string[]}
 */
 // (229ms)
var findRelativeRanks = function(nums) {
    sorted = nums.slice().sort(function(x, y) {
		if(x < y) {
			return 1;
		} else if(x > y) {
			return -1;
		} else {
			return 0;
		}
	});
	dict = {}
	sorted.forEach(function(item, index) {
		if(index == 0) {
			dict[item] = "Gold Medal";
		} else if(index == 1) {
			dict[item] = "Silver Medal";
		} else if(index == 2) {
			dict[item] = "Bronze Medal";
		} else {
			dict[item] = (index + 1).toString();
		}
		
	});
	nums.forEach(function(item, index, array) {
		array[index] = dict[item];
	});
	return nums;
};