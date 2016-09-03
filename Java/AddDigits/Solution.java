/**
 * 这题最容易想到的做法就是使用循环或者递归来求解
 * 但这题是有规律可循的。
 * 不妨写出以下矩阵（输入0时结果也为0）
 * 1	2	3	4	5	6	7	8	9
 * 10	11	12	13	14	15	16	17	18
 * 19	20	21	22	23	24	25	26	27
 * ...
 * 可以看出其是以9为周期的，因此得出以下解法
 * @author phoenix-z
 *
 */
public class Solution {
	  public int addDigits(int num) {
		  if(num == 0)
			  return 0;
		  if(num % 9 == 0)
			  return 9;
	     return num % 9;  
	     //以下代码只需一行即可不写if条件句
	     //return (num - 1) % 9 + 1;
	    }
	  public static void main(String[] args) {
		System.out.println(new Solution().addDigits(38));
	}
}

