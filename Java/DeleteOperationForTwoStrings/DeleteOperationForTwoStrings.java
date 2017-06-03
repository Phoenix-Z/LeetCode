/**
 * (67ms)
 * 这道题目本质上是想求出最长公共子序列（longest common subsequence），有点类似编辑距离。
 * Created by Phoenix-Z on 2017/6/3.
 */
public class DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                dp[i][j] = word1.charAt(i-1) == word2.charAt(j-1) ? 1 + dp[i-1][j-1] : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int lcs = dp[word1.length()][word2.length()];
        return word1.length() - lcs + word2.length() - lcs;
    }

}
