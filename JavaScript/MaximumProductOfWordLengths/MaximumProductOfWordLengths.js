/**
 * @param {string[]} words
 * @return {number}
 */
// (216ms)
var maxProduct = function(words) {
    bitDiff = Array(words.length);
    bitDiff.fill(0);
    for(let i = 0; i < words.length; i++) {
        for(let j = 0; j < words[i].length; j++) {
            bitDiff[i] |= 1 << (words[i].charAt(j).charCodeAt() - 97);
        }
    }
    var max_product = 0;
    for(let i = 0; i < bitDiff.length; i++) {
        for(let j = 0; j < bitDiff.length; j++) {
            if((bitDiff[i] & bitDiff[j]) == 0) {
                max_product = Math.max(max_product, words[i].length * words[j].length);
            }
        }
    }
    return max_product;
};