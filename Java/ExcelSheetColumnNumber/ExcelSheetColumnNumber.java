/**
 * (3ms)
 * 仍然是26进制
 * @author Phoenix-Z
 *
 */
public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
        int ans = 0;
        char[] cs = s.toCharArray();
        int len = cs.length;
        for(int i = len - 1; i >= 0; i--)
        {
        	ans += (cs[i] - 'A' + 1) * (int)Math.pow(26, len - 1 - i);
        }
        return ans;
    }
	
	public static void main(String[] args) {
		String[] strings = {"A", "AA", "Z"};
		ExcelSheetColumnNumber test = new ExcelSheetColumnNumber();
		for(String string : strings)
			System.out.println(test.titleToNumber(string));
 	}
}