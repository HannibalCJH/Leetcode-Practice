class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        # 用字典代替Java中的switch条件语句
        roman = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        sum = 0
        for index in range(len(s)):
            if index + 1 < len(s) and roman[s[index]] < roman[s[index + 1]]:
                sum -= roman[s[index]]
            else:
                sum += roman[s[index]]
        return sum
