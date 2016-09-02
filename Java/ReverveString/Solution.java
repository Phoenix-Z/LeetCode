public class Solution{
	public String reverseString(String s){
		StringBuilder stringBuilder = new StringBuilder(s);
		stringBuilder.reverse();
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().reverseString("hello"));
	}
}
