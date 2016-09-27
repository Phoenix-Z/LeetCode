import java.util.Arrays;

/**
 * (8ms)
 * 这道题最基本的思想就是使用双指针技术，一个从前扫字符串，一个从后扫字符串，遇到两个元音字符就进行交换，
 * 需要注意的是内循环也需要确保i<j，否则结果不正确。
 * 时间复杂度为O(n)，至于如何存储元音字符就见仁见智了。
 * 可以使用HashMap或者HashSet，然后使用get方法或者contains方法看是否是元音字符；
 * 可以像如下这样，放在一个字符数组中(需要保持有序)，然后使用二分搜索，时间复杂度为O(log n)；
 * 也可以将所有元音字符放在一个字符串中，然后使用indexOf方法，如果不存在这个字符，就返回-1，
 * 可利用这一点来判断是否是元音字符。
 * @author Phoenix-Z
 *
 */
public class ReverseVowelsOfString {

	public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        char[] vowels = {'A', 'E', 'I', 'O', 'U','a', 'e', 'i', 'o', 'u'};
        int i = 0;
        int j = sb.length() - 1;
        
        while(i < j)
        {
        	while(Arrays.binarySearch(vowels, sb.charAt(i)) < 0 && i < j)
        		i++;
        	while(Arrays.binarySearch(vowels, sb.charAt(j)) < 0 && i < j)
        		j--;
        	char tmp = sb.charAt(i);
        	sb.setCharAt(i, sb.charAt(j));
        	sb.setCharAt(j, tmp);
        	i++;
        	j--;
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String[] strings = {"aA","hello", "LeetCode" };
		ReverseVowelsOfString test = new ReverseVowelsOfString();
 		for(String string : strings)
			System.out.println(test.reverseVowels(string));
	}
}