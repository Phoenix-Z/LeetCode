/**
 * (8ms)
 * 甚至不使用KMP算法就可以AC。
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        for(int i = 0; i <= haystack.length() - len; i++) {
            if(haystack.substring(i, i + len).equals(needle))
                return i;
        }
        return -1;
    }
}