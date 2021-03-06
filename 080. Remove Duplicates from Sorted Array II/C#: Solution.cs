public class Solution {
    public int RemoveDuplicates(int[] nums) 
    {
        if(nums == null || nums.Length < 3)
            return nums.Length;
        int index = 1, count = 1;
        for(int i = 1; i < nums.Length; i++)
        {
            // 和上一个数相等
            if(nums[i] == nums[i - 1])
            {
                // 计数器加1
                count++;
                // 这个数出现次数小于等于2
                if(count <= 2)
                    nums[index++] = nums[i];
            }
            else
            {
                // 计数器重置为1
                count = 1;
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
