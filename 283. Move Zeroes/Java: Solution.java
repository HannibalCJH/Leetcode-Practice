public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public void moveZeroes(int[] nums) 
    {
        // 指向从头开始交换后的非零元素序列的后一个位置
        int index = 0;
        for(int i = 0; i < nums.length; i++)
        {
            // 该元素不是0，复制到非零序列的后面
            if(nums[i] != 0)
                nums[index++] = nums[i];
        }
        // 把非零序列后面的元素置0
        for(int i = index; i < nums.length; i++)
            nums[i] = 0;
    }
}
