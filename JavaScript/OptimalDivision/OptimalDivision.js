/**
 * (98ms)
 * @param {number[]} nums
 * @return {string}
 */
var optimalDivision = function(nums) {
    var ans;
    switch(nums.length) {
    	case 1: 
    		ans = nums[0].toString();
    		break;
    	case 2:
    		ans = nums[0].toString() + '/' + nums[1].toString();
    		break;
    	default:
    		ans = nums[0].toString() + '/(';
    		for(var i = 1; i < nums.length; i++) {
    			ans += nums[i].toString();
    			if(i < nums.length - 1)
    				ans += '/';
    		}
    		ans += ')';
    }
    return ans;
};