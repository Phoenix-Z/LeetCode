/**
 * (0ms)
 * �����Ŀ��һ���Ǹ�������1����������������ʽ���Σ���Ҫע����Ƕ���ȫ��9������(��999)
 * ����ĳ��Ȼ�����һ��������Ҫ���ж��Ƿ������������
 * plusOne2����˼·��һ���ģ�������Ȼ�жϵĸ��õ㡣
 * @author Phoenix-Z
 *
 */
public class Solution {

	public int[] plusOne(int[] digits) {
		int len = digits.length;
		int count = 0;
		//�ж�digits�Ƿ�ȫ��9
		boolean flag = false;
		
		while(digits[count++] == 9)
		{
			if(count == len)
			{
				flag = true;
				break;
			}

		}
		//���ȫ��9��ֻ��Ҫ����һ�������飬���ȼ�1��������׸�Ԫ��Ϊ1����������Ĭ��ֵ0����
		if (flag) {
			int[] result = new int[len + 1];
			result[0] = 1;
			return result;
		}
		//������ĩβ��ʼ�ӣ���ʱ����Ҫ��������Խ�����⣬��Ϊ�϶�����ĳһλ��ʼֹͣ��λ
		int i = len - 1;
		while(digits[i] + 1 == 10)
		{
			digits[i] = 0;
			i--;
		}
		digits[i] += 1;
		return digits;
    }
	
	public int[] plusOne2(int[] digits) {
        
	    int n = digits.length;
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;
	        }
	        
	        digits[i] = 0;
	    }
	    
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    
	    return newNumber;
	}
	
}