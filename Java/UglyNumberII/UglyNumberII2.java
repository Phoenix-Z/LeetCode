/**
 * (9ms)
 * Created by Phoenix-Z on 2017/6/10.
 */
public class UglyNumberII2 {

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i = 0, j = 0, k = 0;
        for(int r = 1; r < n; r++) {
            ugly[r] = Math.min(ugly[i] * 2, Math.min(ugly[j] * 3, ugly[k] * 5));
            if(ugly[r] == ugly[i] * 2)
                i++;
            if(ugly[r] == ugly[j] * 3)
                j++;
            if(ugly[r] == ugly[k] * 5)
                k++;
        }
        return ugly[n - 1];
    }

}
