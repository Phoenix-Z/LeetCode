/**
 * (142ms)
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    var helper = function(ans, now, candidates, target, pos) {
        if(target <= 0) {
            if(target === 0) {
                ans.push(now.slice());
            }
            return;
        }
        for(var i = pos; i < candidates.length; i++) {
            now.push(candidates[i]);
            helper(ans, now, candidates, target - candidates[i], i);
            now.pop();
        }
    };
    ans = [];
    helper(ans, [], candidates, target, 0);
    return ans;
};