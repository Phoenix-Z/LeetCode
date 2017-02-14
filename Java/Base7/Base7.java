/**
 * (16ms)
 * @author Phoenix-Z
 *
 */
public class Base7 {

	public static String convertToBase7(int num) {
		if(num == 0) {
			return "0";
		}
        StringBuilder ans = new StringBuilder();
        boolean sign = num < 0 ? true : false;
        num = Math.abs(num);
        while(num != 0) {
        	ans.append(num % 7);
        	num = num / 7;
        }
        if(sign) {
        	ans.append("-");
        }
        return ans.reverse().toString();
        // java的类库中有一个方法可以直接进行进制转换，如下一行代码即可
        // return Integer.toString(num, 7);
    }
	
	public static void main(String[] args) {
		System.out.println(convertToBase7(100));
		System.out.println(convertToBase7(-7));
	}
}
