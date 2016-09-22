/**
 * (5ms)
 * ��������������һ���ֶκ�����д���������ʽ������Ͳ����ˡ�
 * ����1~9:����Ϊ1����9����
 * 	  10~99������Ϊ2����90����
 * 	  100~999������Ϊ3����900����
 * ��Ҫע����ǣ������ȴ���9ʱ����Ӧ�����д����ˣ�����ᳬ��������Χ
 * @author Phoenix-Z
 *
 */
public class NthDigit {
	
	public int findNthDigit(int n) {
		//digit��ʼֵΪ��������Ϊ�˺����ж�n�Ƿ�Ϊ����9λ��������
		int digit = -1;
		//now�Ǳ�ʾ����Ϊi�����е���ŷ�Χ
		int now = 1;
		//len��������Χ�ĳ���
		int len = 0;
		for(int i = 0; i < 8; i++)
		{
			len = 9 * (int) Math.pow(10, i) * (i + 1);
			if(now <= n && n < now + len)
			{
				int diff = n - now;
				int num = (int)Math.pow(10, i) + diff / (i + 1);
				digit = (int)(Integer.toString(num).charAt(diff % (i + 1)) - '0');
				break;
			}
			now = now + len;
		}
		//�����ȳ���9������
		if(digit < 0)
		{
			int diff = n - now;
			int num = (int)Math.pow(10, 8) + diff / (8 + 1);
			digit = (int)(Integer.toString(num).charAt(diff % (8 + 1)) - '0');
		}
		return digit;
    }

	public static void main(String[] args) {
		System.out.println(new NthDigit().findNthDigit(1000000000));
	}
	
}