import java.util.ArrayList;
import java.util.List;

/**
 * (10ms)
 * ����һ��
 * ���ܵ������������int��Χ������N���ݴε����ַ����б��У�
 * Ȼ�����ÿ��num,ֻҪ�����ڲ����б��о����ˡ�
 * ������2���ݴε�һ�����裬�����ݴεľͲ�д�ˣ����Ч�������������ȷʵ�͡�����
 * @author Phoenix-Z
 *
 */
public class Solution {
	public boolean isPowerOfTwo(int n) {
        List<Integer> list = new ArrayList<>(32);
		for(int i = 0; i < 31; i++)
		{
			list.add((int)Math.pow(2, i));
		}
		if(list.contains(n))
			return true;
		return false;
    }
}
