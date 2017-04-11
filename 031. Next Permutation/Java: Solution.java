public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public void nextPermutation(int[] nums) 
    {
        if(nums == null || nums.length < 2)
            return;
        
        int i;
         // 从后往前，找到第一个终止降序的数即nums[i + 1] > nums[i]，这样从i+1之后的子数组是降序的
        for(i = nums.length - 2; i >= 0; i--)
        {
            if(nums[i + 1] > nums[i])
                break;
        }
        
        // 不是整个数组都是降序的情况下，找第一个比nums[i]大的数，然后交换i和j位置的数
        if(i >= 0)
        {
            for(int j = nums.length - 1; j >= 0; j--)
            {
                if(nums[j] > nums[i])
                {
                    // i和j交换后后面的子数组依然是递减的，因为原来的nums[j]是第一个比nums[i]大的数，
                    // 交换以后，依然大于j+1之后的元素，而i+1到j-1的元素肯定比原来的nums[j]大也比nums[i]大
                    swap(nums, i, j);
                    break;
                }
            }
        }
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    private void reverse(int[] nums, int left, int right)
    {
        while(left < right)
        {
            swap(nums, left++, right--);
        }
    }
}
