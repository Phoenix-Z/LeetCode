/**
 * (123ms)
*/
public class IntegerToRoman {

    public static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        String[] candidates = null;
        if(num >= 1000) {
        	candidates = new String[] {"M", "MM", "MMM"};
        	roman.append(candidates[num / 1000 - 1]);
        	num %= 1000;
        }
        if(num >= 100) {
        	candidates = new String[] {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        	roman.append(candidates[num / 100 - 1]);
        	num %= 100;
        }
        if(num >= 10) {
			candidates = new String[] {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        	roman.append(candidates[num / 10 - 1]);
        	num %= 10;
        }
        if(num > 0) {
			candidates = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        	roman.append(candidates[num - 1]);
        }
        return roman.toString();
    }

	public static void main(String[] args) {
		System.out.println(intToRoman(3999));
	}
}