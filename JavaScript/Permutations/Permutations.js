/**
 * @param {number[]} nums
 * @return {number[][]}
 */
// (119ms) 递归的做法
var permute = function(nums) {
   var helper = function(ans, now, nums) {
       if(now.length == nums.length) {
           ans.push(now.slice());
           return;
       }
       for(let i = 0; i < nums.length; i++) {
           if(now.indexOf(nums[i]) >= 0) {
               continue;
           }
           now.push(nums[i]);
           helper(ans, now, nums);
           now.pop();
       }
   }
   ans = [];
   helper(ans, [], nums);
   return ans;
};

// (115ms) 迭代的做法，splice函数既可以在指定位置添加元素又可以删除元素
var permute = function(nums) {
    if(nums.length == 0)
        return [[]];
    ans = [];
    ans.push([nums[0]]);
    for(let i = 1; i < nums.length; i++) {
        var size = ans.length;
        while(0 < size--) {
            now = ans.shift();
            for(let j = 0; j <= now.length; j++) {
                now.splice(j, 0, nums[i]);
                ans.push(now.slice());
                now.splice(j, 1);
            } 
        }
    }
    return ans;
};