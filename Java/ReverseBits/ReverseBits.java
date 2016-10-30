/**
 * (12ms)
 * 这个方法充分利用了java提供的一些方法，但需要注意的是Integer的转换为二进制的方法是没有前导0的，
 * 所以需要补足32位。
 * @author Phoenix-Z
 *
 */
public class ReverseBits {

	public int reverseBits(int n) {
		//将整数转换为二进制字符串
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        int len = sb.length();
        //逆置字符串
        sb.reverse();
        //对于长度不足32位的进行补足
        for(int i = 0; i < 32 - len; i++)
        	sb.append(0);
        //将二进制字符串转换为无符号整型
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
	
	public static void main(String[] args) {
		System.out.println(new ReverseBits().reverseBits(43269615));
	}
}