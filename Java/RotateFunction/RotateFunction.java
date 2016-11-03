/**
 * (4ms)
 * 这个做法非常聪明。需要写一下递推公式：
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]
 * F(k-1) = 0 * Bk-1[0] + 1 * Bk-1[1] + ... + (n-1) * Bk-1[n-1]
 * 	      = 0 * Bk[1] + 1 * Bk[2] + ... + (n-2) * Bk[n-1] + (n-1) * Bk[0]
 * 所以有：F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] + (1-n)Bk[0]
 * 					    = (Bk[0] + ... + Bk[n-1]) - nBk[0]
 * 						= sum - nBk[0]
 * 进而有：F(k) = F(k-1) + sum - nBk[0]
 * 而Bk[0]是什么呢？
 * k = 0; B[0] = A[0];
 * k = 1; B[0] = A[len-1];
 * k = 2; B[0] = A[len-2];
 * ...
 * 写出递推公式后，程序就很好完成了。时间复杂度为O(n)
 * @author Phoenix-Z
 *
 */
public class RotateFunction {

	public int maxRotateFunction(int[] A) {
		//如果A中没有元素，返回值为0
		if(A.length == 0){
            return 0;
        }
        //sum是数组所有元素之和，iteration表示每一轮的递推值
        int sum =0, iteration = 0, len = A.length;
        //求解sum，和第一轮递推值，即F(0)
        for(int i=0; i<len; i++){
            sum += A[i];
            iteration += (A[i] * i);
        }
        
        int max = iteration;
        for(int j=1; j<len; j++){
            //使用递推公式求解下一轮的迭代值，并更新当前最大值
            iteration = iteration - sum + A[j-1] * len;
            max = max > iteration ? max : iteration;
        }
        
        return max;
    }
	
}