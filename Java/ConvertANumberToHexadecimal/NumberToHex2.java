/**
 * (8ms)
 * 这个方法显然效率更高一些，它是直接右移四位然后和15(0x1111)进行与运算得到四位的整数值，这是个好做法
 * 同样是需要使用绝对右移的。原作者使用的是String的类型，这里我改用了StringBuilder，从提交结果来看，
 * 效率更高一些。
 * @author Phoenix-Z
 *
 */
public class NumberToHex2 {

	private char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
        if(num == 0) 
        	return "0";
        StringBuilder result = new StringBuilder();
        while(num != 0){
        	//当num不为0时，再添加至result中，防止出现前置0
            result.append(map[(num & 15)]); 
            num = (num >>> 4);
        }
        return result.reverse().toString();
    }
	
    public static void main(String[] args) {
		int[] nums = {0, 26, -1};
		NumberToHex aHex = new NumberToHex();
		for(int num : nums)
			System.out.println(aHex.toHex(num));
	}
}