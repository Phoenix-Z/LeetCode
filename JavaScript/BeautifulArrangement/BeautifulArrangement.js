/**
 * @param {number} N
 * @return {number}
 */
// (172ms)
var countArrangement = function(N) {
    var helper = function(used, N, now){
        if(now < 2) {
            ans++;
            return;
        }
        for(let i = 1; i <= N; i++) {
            if(used[i])
                continue;
            if(i % now == 0 || now % i == 0) {
                used[i] = true;
                helper(used, N, now - 1);
                used[i] = false;
            }
        }
    };
    var ans = 0;
    used = new Array(N + 1);
    used.fill(false);
    helper(used, N, N);
    return ans;
};