public class Solution {
    // 最简单的方法，遍历数组，判断一个数是不是大于自己左右邻居
    // 时间复杂度O(n)，空间复杂度O(1)
    public int findPeakElement(int[] nums) 
    {
        if(nums == null || nums.length < 2)
            return 0;
            
        for(int i = 1; i < nums.length - 1; i++)    
        {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        }
        // 在下标1到n-1没找到那就在两个端点找，只要找一个就行
        return nums[0] > nums[1] ? 0 : nums.length - 1;
    }
}
