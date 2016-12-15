/**
 * (2ms)
 * 数字切片是指连续的三个数字，这三个数字构成等差数列，如果有三个数字成等差数列，那么切片个数为1，
 * 如果有四个数字成等差数列，那么切片个数为2(考虑顺序)+1,依此类推，如果有n(n>=3)个数字成等差数列，
 * 那么切片个数为f(n)=f(n-1)+(n-2)。在对数组遍历时，使用count来计算有多少个连续的数字构成等差数列，
 * 进而在迭代的过程中，计算最后的结果。一旦连续的数字中断了，将count恢复到初始值即可。
 * @author Phoenix-Z
 *
 */
public class ArithmeticSlices {

	public int numberOfArithmeticSlices(int[] A) {
		//如果数组是空引用，或者数组的长度小于3，就不存在所需的数字切片
		if(A == null || A.length < 3)
            return 0;
        int num = 0;
		int count = 0;
		for(int i = 2; i < A.length; i++) {
			//如果连续的三个数字构成等差数列，count增加1，同时num加上当前的count值
			if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				num += ++count;
			} else {//如果当前数字与之前的数字不能构成等差数列，就将count复位
				count = 0;
			}
		}
		return num;
    }
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4};
		System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(A));
	}
}