class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if nums == None or len(nums) < 2:
            return []
        # 初始化空字典
        map = {}
        # 用enumerate函数可以返回索引和值
        for i, n in enumerate(nums):
            key = target - n
            if key in map:
                return [map[key], i]
            
            map[n] = i
        return [0, 0]
