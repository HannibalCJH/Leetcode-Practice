public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public void wiggleSort(int[] nums) 
    {
        boolean less = true;
        // 每次比较当前元素和下一个元素
        for(int i = 0; i < nums.length - 1; i++)
        {
            // 这组元素应该前一个比后一个小
            if(less)
            {
                // 顺序不对就交换
                if(nums[i] > nums[i + 1])
                    swap(nums, i, i + 1);
            }
            else
            {
                // 这组元素应该前一个比后一个大，顺序不对就交换
                if(nums[i] < nums[i + 1])
                    swap(nums, i, i + 1);
            }
            // 每次切换判断模式
            less = !less;
        }
    }
    
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
