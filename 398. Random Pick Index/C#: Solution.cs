public class Solution {
    int[] nums;
    Random rnd;

    public Solution(int[] nums) 
    {
        this.nums = nums;
        this.rnd = new Random();
    }
    
    // 时间复杂度O(n)，空间复杂度O(1)
    public int Pick(int target) 
    {
        // 如果不存在则返回下标为-1
        int result = -1;
        // 计数器，记录数组中有几个等于target值
        int count = 0;
        for(int i = 0; i < nums.Length; i++) 
        {
            // 等于target值
            if(nums[i] == target)
            {
                if(rnd.Next(++count) == 0)
                    result = i;
            }
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.Pick(target);
 */
