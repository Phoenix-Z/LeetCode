/**
 * (62ms)
 * ���������������⣬��discuss��Ҳ�������������ô������������numRows��StringBuilder,
 * Ȼ����"֮"���ͽ��ַ��ֱ���ӵ���Ӧ��StringBuilder�У�����ٽ����е�StringBuilder����
 * ˳�����ӵ�һ��
 * ֮����ʹ��StringBuilder����Ϊ��Java��String�ǲ��ɱ�ģ�ÿ���޸��ַ���ʵ���϶����½�һ��
 * ���󣬶�ʹ��StringBuilder��Ч�ʸ��ߡ�
 * @author Phoenix-Z
 *
 */
public class ZigZag {

	public String convert(String s, int numRows) {
		StringBuilder[] str = new StringBuilder[numRows];
		//�������С��2�������������ַ��������Ϳ���ֱ�ӷ����ַ���
		if (numRows < 2 || numRows >= s.length()) {
			return s;
		}
		
		else {
			//indexָ����Ҫ��ӵ�StringBuilder�е�s�е��ַ�λ��
			int index = 0;
			
			int len = s.length();
			
			for(int i = 0; i < numRows; i++)
			{
				str[i] = new StringBuilder();
			}
			
			//jָ��ڼ���StringBuilder
			int j = 0;
			while(index < len)
			{
				//�������
				while (j < numRows && index < len) {
					str[j++].append(s.charAt(index++));
				}
				//ע����Ҫ��ȥ2
				j -= 2;
				//�������
				while(j > 0 && index < len) {
					str[j--].append(s.charAt(index++));
				}
			}
			
			//�����е�StringBuilder��������
			for(int i = 1; i < numRows; i++)
			{
				str[0].append(str[i]);
			}
		}
		
		return str[0].toString();
    }
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		System.out.println(new ZigZag().convert(s, numRows));
	}
}