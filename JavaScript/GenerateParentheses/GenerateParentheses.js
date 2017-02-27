/**
 * @param {number} n
 * @return {string[]}
 */
// (92ms)
var generateParenthesis = function(n) {
    var ans = [];
    generateHelper("", 0, n, ans);
    return ans;
};

var generateHelper = function(now, lenOfLeft, totalLen, ans) {
    if(now.length == totalLen * 2) {
        ans.push(now);
    }
    if(lenOfLeft < totalLen) {
        generateHelper(now + "(", lenOfLeft + 1, totalLen, ans);
    }
    if(now.length - lenOfLeft < lenOfLeft) {
        generateHelper(now + ")", lenOfLeft, totalLen, ans);
    }
}
