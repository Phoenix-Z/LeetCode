/**
 * (2ms)
 * ��������
 * ���ַ���ҲЧ�ʼ��ߣ�ͬʱ����һ������չ�ԣ������������ݴε��жϺ���Ч��
 * ����˼·�ǣ�
 * (1)��int��ֵ��Χ���ҵ�N������ݴ�,����2���ԣ�int��Χ��[-2^31,2^31-1]��
 * �������Ϊ2^30;
 * (2)һ����ʵ��2^30 % 2 ^ i == 0(i = 0, 1, 2, ..., 30)
 * ���Կ���д�����µ��ж����(���µ�ʹ�õ�2^31,����ԭ����һ�µ�)
 * @author Phoenix-Z
 *
 */
public class Solution3 {
	public boolean isPowerOfTwo(int n) {
		long max = Integer.MAX_VALUE + 1;
		return (n > 0) && (max % n == 0);
	}
//	public static void main(String[] args) {
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println((int)Math.pow(2,31));
//	}
}