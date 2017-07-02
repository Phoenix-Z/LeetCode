/**
 * (23ms)
 * Created by Phoenix-Z on 2017/7/2.
 */
public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        for(int i = 0; i <= Math.sqrt(c); i++) {
            if(isSquare(c - i * i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSquare(int num) {
        return num == 0 || num == (int)Math.pow((int)Math.sqrt(num), 2);
    }

}
