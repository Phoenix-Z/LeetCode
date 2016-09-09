import java.util.HashSet;
import java.util.Set;

/**
 * �������ά���ٿ����й���Happy Number�Ľ���
 * https://en.wikipedia.org/wiki/Happy_number#Popular_culture
 * (7ms)
 * ����������ǰ�ÿ�ε����������м������뵽set���У��������������ظ�������
 * ������ѭ�����Ա��������ѭ����
 * 
 * ��discuss�д��������ؽ�������жϵ�nС��5����n����1ʱ����ѭ��������û�п�������Ľ���
 * ȷʵЧ������ˣ������Ҫ��ѧ�����֤�����Կ�ά���ٿ�
 * @author Phoenix-Z
 *
 */
public class Solution {

	public boolean isHappy(int n) {
		//��Set�ж�ĳ�������Ƿ���ֹ���
		Set<Integer> exists = new HashSet<>();
		
		//now��ʾ���������е��м���
		int now = splitNum(n);
		exists.add(now);
		
		while(now != 1){
			now = splitNum(now);
			//����Ѿ����ֹ�������ѭ��
			if(exists.contains(now))
			{
				break;
			}
			exists.add(now);
		}
		if (now == 1) {
			return true;
		}
		return false;
    }
	
	public int splitNum(int n){
		int ans = 0;
		while(n > 0)
		{
			ans += (int)Math.pow(n % 10, 2);
			n = n / 10;
		}
		return ans;
	} 
	
	public static void main(String[] args) {
		System.out.println(new Solution().isHappy(2));
	}
}