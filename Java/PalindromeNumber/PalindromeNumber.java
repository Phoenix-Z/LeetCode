/**
 * (189ms)
 * 这道题不允许使用额外的连续的空间，也就意味着不好转换成String来做，
 * 下面是一种做法，比如 1234321；
 * 每次通过除以10和对10取余来保存下前半部分x和后半部分v，比如 x = 123432, v=1;
 * 直到x=123，v=1234的时候，循环结束，再通过 v/10 == x，来判断数是不是回环的。
 * @author Phoenix-Z
 *
 */
public class PalindromeNumber {

	static int v;
    public static boolean isPalindrome(int x) {
        //optimizations
        if(x<0) return false;
        if(x<10) return true;
        if(x%10==0) return false;
        if(x<100&&x%11==0) return true;
        if(x<1000&&((x/100)*10+x%10)%11==0) return true;

        //actual logic
        v=x%10;
        x=x/10;
        while(x-v>0)
        {
        	v=v*10+x%10;
        	x/=10;
        }
        if(v>x){v/=10;}
        return v==x?true:false;
    }
	
	public static void main(String[] args) {
		System.out.println(PalindromeNumber.isPalindrome(1000021));
	}
}