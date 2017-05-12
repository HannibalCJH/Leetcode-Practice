class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        power = 1
        while power < n:
            power *= 2
        return power == n
