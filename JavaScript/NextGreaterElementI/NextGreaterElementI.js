/**
 * @param {number[]} findNums
 * @param {number[]} nums
 * @return {number[]}
 */
 // (192ms)
var nextGreaterElement = function(findNums, nums) {
    var greater = new Map();
	var stack = []
	nums.forEach(function(item){
		while(stack.length > 0 && stack[stack.length - 1] < item) {
			greater.set(stack.pop(), item);
		}
		stack.push(item);
	});
	findNums.forEach(function(item, index, array){
		if(greater.get(item)) {
			array[index] = greater.get(item);
		} else {
			array[index] = -1;
		}
	});
	return findNums;
};

// (142ms)
// 直接使用{}比使用Map效率更高
var nextGreaterElement = function(findNums, nums) {
    var greater = {};
	var stack = []
	nums.forEach(function(item){
		while(stack.length > 0 && stack[stack.length - 1] < item) {
			greater[stack.pop()] = item;
		}
		stack.push(item);
	});
	findNums.forEach(function(item, index, array){
		array[index] = greater[item] ? greater[item] : -1;
	});
	return findNums;
};

// (129ms)
// javascript的map实现的也很差
var nextGreaterElement2 = function(findNums, nums) {
    var ans = [];
    findNums.forEach(function(item){
        var i = 0;
        while(nums[i] != item) {
            i++;
        }
        for(i = i + 1; i < nums.length; i++) {
            if(nums[i] > item) {
                ans.push(nums[i]);
                break;
            }
        }
        if(i == nums.length) {
            ans.push(-1);
        }
    });
	return ans;
};