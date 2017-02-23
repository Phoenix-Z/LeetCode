/**
 * @param {string} word
 * @return {boolean}
 */
// (115ms)
var detectCapitalUse = function(word) {
    return (/^([A-Z]+|[A-Z]?[a-z]+)$/).test(word);
};
// (136ms)
var detectCapitalUse2 = function(word) {
    return word == word.toUpperCase() || word.slice(1) == word.slice(1).toLowerCase();
};