/**
 * (1ms)
 * ��������ǿ��ǵ�10 = 2 * 5������2��˵����Դ�ḻ������5��ϡȱ��Դ�����ֻҪ��1��n��
 * �ж��ٸ�5���Ϳ���ȷ������ж��ٸ�0��
 * @author Phoenix-Z
 *
 */
public class TrailingZeroes2 {

	public int trailingZeroes(int n) {
		//count��ĩβ0�ĸ���
		int count = 0;
		
		//���ǵ�����5 * 5֮��ģ�ÿһ��5�����Բ���һ��10��������Ҫ�ҵ����е�5
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
