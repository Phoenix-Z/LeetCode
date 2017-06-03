/**
 * (162ms)
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
    var dp = new Array(word1.length + 1);
    for(var i = 0; i <= word1.length; i++) {
    	dp[i] = new Array(word2.length + 1);
    	
   		for(var j = 0; j <= word2.length; j++) {
   			if(i == 0 || j == 0) {
   				dp[i][j] = 0;
   			} else {
   				dp[i][j] = word1[i-1] == word2[j-1] ? 1 + dp[i-1][j-1]: Math.max(dp[i-1][j], dp[i][j-1]);
   			}
   		}
    }
	return word1.length + word2.length - dp[word1.length][word2.length] * 2;
};