/**
 * (31ms)
 * 这个方法就是每遇到一个素数，就把小于n的它的倍数置为true，那么剩下来的就是素数。
 * 就是利用空间换时间(Sieve of Eratosthenes)
 * @author Phoenix-Z
 *
 */
public class CountPrimes {

	public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
       int count = 0;
       for (int i=2; i<n; i++) {
           if (notPrime[i])
               continue;
           count++;
           for (int j=i; j<n; j=j+i)
               notPrime[j] = true;
       }
        
       return count;
   }
	
	public static void main(String[] args) {
		int[] nums = {5, 3};
		CountPrimes test = new CountPrimes();
		for(int num : nums)
		{
			System.out.println(test.countPrimes(num));
		}
	}
}
