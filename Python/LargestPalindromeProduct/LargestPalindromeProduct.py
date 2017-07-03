class Solution(object):
    # (995ms)
    def largestPalindrome(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 9
        upper, lower, palindromeFound= 10 ** n - 1, 10 ** (n-1) -1, False
        left = upper * upper / (10**n)
        while not palindromeFound:
            palindrome = int(str(left) + str(left)[::-1])
            if (len(str(palindrome))%2==0):
                for i in xrange(upper / 11,(lower+1) / 11,-1):
                    if (palindrome / (11*i) > upper):
                        break
                    if ((palindrome % (11*i)) == 0):
                        palindromeFound = True
                        break
            else:
                for i in xrange(upper, lower + 1, -1):
                    if (palindrome / i > upper or i * i < palindrome):
                        break
                    if (palindrome % i == 0):
                        palindromeFound = True
                        break   
            left -= 1
        return palindrome % 1337
