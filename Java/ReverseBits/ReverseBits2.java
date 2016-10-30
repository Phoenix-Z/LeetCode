/**
 * (3ms)
 * 这个方法就是先获取每一位上的bit，然后在拼装成整数。
 * 但是事实上并不需要保存每一位上的bit，只需要判断是0还是1即可，注释部分是优化。
 * @author Phoenix-Z
 *
 */
public class ReverseBits2 {

	public int reverseBits(int n) {
		int[] bits = new int[32];
		int j = 0;
		//获取32个bit位
		while(j < 32)
		{
			bits[j++] = n & 1;
			n >>>= 1;
		}
		int ans = 0;
		//将bit拼装成整数
		for(int i = 0; i < 32; i++)
		{
			ans = (ans << 1) | bits[i];
		}
		/*
		 * 这部分是优化，不要一个整型数组来保存bit值
		 * for (int i = 0; i < 32; i++) {
		 * 		ans <<= 1;
		 * 		if ((n & 1) == 1) 
		 * 			ans++;
		 * 		n >>= 1;
		 * 	}
		 */
		return ans;
    }
	
	public static void main(String[] args) {
		System.out.println(new ReverseBits2().reverseBits(43261596));
	}
}