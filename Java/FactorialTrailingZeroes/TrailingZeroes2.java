/**
 * (1ms)
 * 这个方法是考虑到10 = 2 * 5，对于2来说，资源丰富，但是5是稀缺资源，因此只要看1到n中
 * 有多少个5，就可以确定最后有多少个0。
 * @author Phoenix-Z
 *
 */
public class TrailingZeroes2 {

	public int trailingZeroes(int n) {
		//count是末尾0的个数
		int count = 0;
		
		//考虑到会有5 * 5之类的，每一个5都可以产生一个10，所以需要找到所有的5
		while(n / 5 != 0)
		{
			count += n / 5;
			n = n / 5;
		}
        return count;
    }
	
	public static void main(String[] args) {
		System.out.println(new TrailingZeroes().trailingZeroes(1808548329));
	}
	
}
