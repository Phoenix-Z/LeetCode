/**
 * (2ms)
 * 这是一个分治的做法，它首先将前16bit和后16bit交换，然后对于前16bit的前8bit和后8bit交换，
 * 依次类推，直至将所有bit都逆置。显然，这个做法的效率很高。
 * 需要注意的是，右移操作需要使用>>>,否则最高位不会移动。
 * @author Phoenix-Z
 *
 */
public class ReverseBits3 {

	public int reverseBits(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
	
}