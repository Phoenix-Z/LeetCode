/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
// (122ms)
var isSubsequence = function(s, t) {
    if(s == "") {
        return true;
    }
    var i = 0, j = 0;
    while(i < t.length && j < s.length) {
        if(t[i++] == s[j]) {
            j++;
        }
    }
    return j == s.length;
};