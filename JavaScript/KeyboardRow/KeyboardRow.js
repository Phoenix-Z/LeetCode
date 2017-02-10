/**
 * @param {string[]} words
 * @return {string[]}
 */
 // (125ms)
var findWords = function(words) {
return words.filter(x => (/^([qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*)$/i).test(x));
};