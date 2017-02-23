public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int removeDuplicates(int[] nums) 
    {
        if(nums == null || nums.length == 0)
            return 0;
            
        int index = 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] != nums[i - 1])
            {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
