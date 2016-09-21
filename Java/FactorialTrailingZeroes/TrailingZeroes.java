/**
 * ��ʱ
 * ���������Ȼ��ʱ�ˣ���������Ȼ������Щ�ط�����Ȥ�����������ʱ�临�Ӷ���O(n)��
 * ����ʵ����һ���׳ˡ�����Ϊ�˷�ֹ���ֳ������͵ķ�Χ����Ҫ�ڳ���ĳһ����ֵ��ʱ��ֻ�������ļ�λ
 * ���������ֵӦ�ö�󣬲��ö�֪�����ң���n�ǳ����ʱ����Ȼ����Խ���Σ�գ����Բ��Ƽ�ʹ���������
 * @author Phoenix-Z
 *
 */
public class TrailingZeroes {

	public int trailingZeroes(int n) {
		int count = 0;
		int product = 1;
		for(int i = 2; i <= n; i++)
		{
			product *= i;
			while(product > 10 && product % 10 == 0)
			{
				count++;
				product /= 10;
			}
			product %= 100000;
		}
        return count;
    }
	
	public static void main(String[] args) {
		System.out.println(new TrailingZeroes().trailingZeroes(100));
	}
}
