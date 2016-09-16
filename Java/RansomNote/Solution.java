/**
 * (14ms)
 * 这道题同第242题(valid anagram)的思路基本是一样的，题目也假设了输入的两个字符串都是由小写字母构成的
 * 首先扫描一遍magazine，记录每个字母出现的次数，然后再扫描一遍ransomNote即可。
 * Created by Phoenix-Z on 2016/9/16.
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //count数组记录每个字母出现的次数
        int[] count = new int[26];

        //遍历magazine，记录每个字母出现的次数
        for(char c : magazine.toCharArray())
        {
            count[c - 'a']++;
        }

        //遍历ransomNote，看出现的字母可否由ransomNote构成
        for (char c : ransomNote.toCharArray())
        {
            if(count[c - 'a'] > 0)
            {
                count[c - 'a']--;
            }
            else
            {
                return  false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(new Solution().canConstruct(ransomNote, magazine));
    }
}
