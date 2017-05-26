class Solution(object):

    def get_gcd(self, a, b):
        if a < b:
            a, b = b, a
        if b == 0 or a % b == 0:
            return b
        return self.get_gcd(b, a % b)

    def get_lcm(self, a, b):
        gcd = self.get_gcd(a, b)
        return a / gcd * b

    def add(self, one, another):
        lcm = self.get_lcm(one[1], another[1])
        one[0] *= lcm / one[1]
        one[1] = lcm
        another[0] *= lcm / another[1]
        one[0] += another[0]
        return one

    def sub(self, one, another):
        lcm = self.get_lcm(one[1], another[1])
        one[0] *= lcm / one[1]
        one[1] = lcm
        another[0] *= lcm / another[1]
        one[0] -= another[0]
        return one

    # (65ms)
    def fractionAddition(self, expression):
        """
        :type expression: str
        :rtype: str
        """
        import re
        nums = re.split('[+-]', expression)
        if expression[0] == '-':
            nums = nums[1:]
            nums[0] = '-' + nums[0]
        fractions = []
        for num in nums:
            fractions.append(map(int, num.split('/')))
        ans, i = fractions[0], 1
        for c in expression[1:]:
            if i >= len(fractions):
                break
            if c == '+':
                ans = self.add(ans, fractions[i])
                i += 1
            elif c == '-':
                ans = self.sub(ans, fractions[i])
                i += 1
        gcd = self.get_gcd(abs(ans[0]), ans[1])
        return '{}/{}'.format(ans[0] / gcd, ans[1] / gcd) if gcd else '0/1'


print Solution().fractionAddition('-4/7-3/4+2/3')
