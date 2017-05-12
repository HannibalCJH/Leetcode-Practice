class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        power = 1
        while power < num:
            power *= 4
        return power == num
