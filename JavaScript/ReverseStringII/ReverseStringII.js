/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
 //(105ms)
var reverseStr = function(s, k) {
    var ans = '';
    for(let i = 0; i < s.length; i += k) {
        let end = Math.min(i + k, s.length);
        if(Math.floor(i / k) % 2 === 0)
            ans += s.slice(i, end).split('').reverse().join('');
        else
            ans += s.slice(i, end);
    }
    return ans;
};