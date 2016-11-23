import java.util.Arrays;

/**
 * (12ms)
 * 这个方法是先对字符串数组先进行排序，排序过后，只需要比较排序后的第一个字符串和最后一个字符串的
 * 共同前缀即可。因为java中对字符串的排序是根据字典顺序排序的，所以只需要比较第一个和最后一个即可。
 * @author Phoenix-Z
 *
 */
public class LongestCommonPrefix2 {

	public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        
        if (strs!= null && strs.length > 0){
        
        	//先对字符串数组进行排序
            Arrays.sort(strs);
            
            char [] a = strs[0].toCharArray();
            char [] b = strs[strs.length-1].toCharArray();
            
            //只需要比较第一个字符串和最后一个字符串的共同前缀即可
            for (int i = 0; i < a.length; i ++){
                if (b.length > i && b[i] == a[i]){
                    result.append(b[i]);
                }
                else {
                    return result.toString();
                }
            }
        }
        return result.toString();
    }
	
}
