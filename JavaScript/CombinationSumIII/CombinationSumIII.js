/**
 * Created by Phoenix-Z on 2017/4/24.
 */
/**
 * (99ms)
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function(k, n) {
    var ans = [];
    var dfs = function (ans, now, nowK, nowN) {
        if(nowK == 0 && nowN == 0) {
            ans.push(now.slice());
            return;
        }
        if(nowK < 0 || nowN < 0)
            return;
        for(var i = now.length == 0 ? 1 : now[now.length - 1] + 1; i <= 9; i++) {
            now.push(i);
            dfs(ans, now, nowK - 1, nowN - i);
            now.pop();
        }
    };
    dfs(ans, [], k, n);
    return ans;
};