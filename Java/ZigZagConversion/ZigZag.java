/**
 * (62ms)
 * 这个方法很容易理解，在discuss中也看到大多数人这么做，就是生成numRows个StringBuilder,
 * 然后按照"之"字型将字符分别添加到相应的StringBuilder中，最后再将所有的StringBuilder按照
 * 顺序连接到一起。
 * 之所以使用StringBuilder是因为在Java中String是不可变的，每次修改字符串实际上都是新建一个
 * 对象，而使用StringBuilder会效率更高。
 * @author Phoenix-Z
 *
 */
public class ZigZag {

	public String convert(String s, int numRows) {
		StringBuilder[] str = new StringBuilder[numRows];
		//如果行数小于2或者行数大于字符串长，就可以直接返回字符串
		if (numRows < 2 || numRows >= s.length()) {
			return s;
		}
		
		else {
			//index指向需要添加到StringBuilder中的s中的字符位置
			int index = 0;
			
			int len = s.length();
			
			for(int i = 0; i < numRows; i++)
			{
				str[i] = new StringBuilder();
			}
			
			//j指向第几行StringBuilder
			int j = 0;
			while(index < len)
			{
				//正向添加
				while (j < numRows && index < len) {
					str[j++].append(s.charAt(index++));
				}
				//注意需要减去2
				j -= 2;
				//反向添加
				while(j > 0 && index < len) {
					str[j--].append(s.charAt(index++));
				}
			}
			
			//将所有的StringBuilder连接起来
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