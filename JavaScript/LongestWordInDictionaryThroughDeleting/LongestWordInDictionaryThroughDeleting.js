/**
 * (152ms)
 * @param {string} s
 * @param {string[]} d
 * @return {string}
 */
var findLongestWord = function(s, d) {
    var res = '';
    for(let ss of d) {
    	if(ss.length >= res.length && isSequence(s, ss) && (ss.length > res.length || ss < res))
    		res = ss;
    }
    return res;
};

var isSequence = function(s, ss) {
	var i = 0, j = 0;
	while(i < s.length && j < ss.length) {
		if(s[i++] == ss[j])
			j++;
	}
	return j == ss.length;
};

var s = "abpcplea", d = ["ale","apple","monkey","plea"];
console.log(findLongestWord(s, d));