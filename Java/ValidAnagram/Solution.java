import java.util.Arrays;

/**
 * (8ms)
 * ������ǳ����������������һ������Ϊ26�����飬Ȼ��ɨ��s����������ĸ���ֵĴ���(��Ŀ
 * ���Ĳ�����������Сд��Ӣ����ĸ)��Ȼ���ڶ�t��ɨ�裬�������Ϊ0���򲻴�����Ӧ���ַ���
 * ��������������������չ������Unicode�ַ������������޷��������ַ���������������
 * ��������������ֵ���Ƽ���
 * �Ƚ������ַ���תΪ�ַ����飬����ʹ����toCharArray()���������������split����Ч�ʸ��ߣ�
 * ��������������ص���char�����飬������String���͵����顣
 * Ȼ���������������������һ�Ƚ�ÿ���ַ��Ƿ���ȣ��������ȣ���˵��ʹ���˲�һ�����ַ���
 * @author Phoenix-Z
 *
 */
public class Solution2 {

	public boolean isAnagram(String s, String t) 
	{
		if(s.length() != t.length())
			return false;
		//���ַ���ת��Ϊ�ַ�����
	    char[] sChar = s.toCharArray();
	    char[] tChar = t.toCharArray();
	    
	    //����������
	    Arrays.sort(sChar);
	    Arrays.sort(tChar);
	    
	    //����ֱ��ʹ����Arrays�еķ������Ƚ������Ƿ����
	    return Arrays.equals(sChar, tChar);   
	}
	
	public static void main(String[] args) {
		String s = "�й�����";
		String t = "�����й�";
		System.out.println(new Solution().isAnagram(s, t));
	}
}