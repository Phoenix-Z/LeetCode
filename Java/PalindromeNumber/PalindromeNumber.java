/**
 * (189ms)
 * ����ⲻ����ʹ�ö���������Ŀռ䣬Ҳ����ζ�Ų���ת����String������
 * ������һ������������ 1234321��
 * ÿ��ͨ������10�Ͷ�10ȡ����������ǰ�벿��x�ͺ�벿��v������ x = 123432, v=1;
 * ֱ��x=123��v=1234��ʱ��ѭ����������ͨ�� v/10 == x�����ж����ǲ��ǻػ��ġ�
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