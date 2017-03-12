/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
// (252ms)
var combine = function(n, k) {
    var helper = function(ans, now, n, k, prev) {
        if(now.length == k) {
            ans.push(now.slice());
            return;
        }
        for(let i = prev + 1; i <= n; i++) {
            now.push(i);
            helper(ans, now, n, k, i);
            now.pop();
        }
    };
    var ans = [];
    helper(ans, [], n, k, 0);
    return ans;
};
