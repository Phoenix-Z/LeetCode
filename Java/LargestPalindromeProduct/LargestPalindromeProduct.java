/**
 * (542ms)
 * Created by Phoenix-Z on 2017/6/18.
 */
public class LargestPalindromeProduct {

    public int largestPalindrome(int n) {
        if(n == 1)
            return 9;
        long upperBound = (int)Math.pow(10, n) - 1, lowerBound = upperBound / 10;
        long maxProduct = upperBound * upperBound, product = upperBound * upperBound;
        long leftHalf = maxProduct / (int)Math.pow(10, n);
        boolean palindromeFound = false;
        while(!palindromeFound) {
            product = createPalindrome(leftHalf);
            for(long i = upperBound; i * i >= product; i--) {
                if(product / i <= lowerBound)
                    break;
                if(product % i == 0) {
                    palindromeFound = true;
                    break;
                }
            }
            leftHalf--;
        }
        return (int) (product % 1337);
    }

    private long createPalindrome(long leftHalf) {
        String palindrome = leftHalf + new StringBuilder(Long.toString(leftHalf)).reverse().toString();
        return Long.parseLong(palindrome);
    }

    public static void main(String[] args) {
        LargestPalindromeProduct test = new LargestPalindromeProduct();
        System.out.println(test.largestPalindrome(2));
    }

}
