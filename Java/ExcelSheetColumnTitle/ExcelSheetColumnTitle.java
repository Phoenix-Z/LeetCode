/**
 * (0ms)
 * 这题就相当于26进制
 * @author Phoenix-Z
 *
 */
public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
        StringBuilder title = new StringBuilder();
        
        while(n > 0)
        {
        	title.append((char)('A' + (n - 1) % 26));
        	n = (n - 1) / 26;
        }
        
        return title.reverse().toString();
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 27, 28, 26};
		ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
		for(int num : nums)
			System.out.println(test.convertToTitle(num));
	}
}
