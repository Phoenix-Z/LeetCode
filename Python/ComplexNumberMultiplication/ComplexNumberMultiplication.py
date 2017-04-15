class Solution(object):
	# (38ms)
    def complexNumberMultiply(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        numA, numB = map(int, a[:-1].split('+')), map(int, b[:-1].split('+'))
        return '%d+%di' % (numA[0]*numB[0] - numA[1]*numB[1], numA[0]*numB[1] + numA[1]*numB[0])