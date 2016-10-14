/**
 * (6ms)
 * 这个做法就是从字符串的尾部往前扫描，根据空格符来确定最后一个单词的位置，从而确定长度。
 * @author Phoenix-Z
 *
 */
public class LengthOfLastWord2 {

	public int lengthOfLastWord(String s) {
		/*
		 * 以下代码和这一行的代码的思路基本一致。
		 * return s.trim().length()-s.trim().lastIndexOf(" ")-1;
		 */
	    int len=s.length(), lastLength=0;
	    
	    while(len > 0 && s.charAt(len-1)==' '){
	        len--;
	    }
	    
	    while(len > 0 && s.charAt(len-1)!=' '){
	        lastLength++;
	        len--;
	    }
	    
	    return lastLength;
	}
	
}