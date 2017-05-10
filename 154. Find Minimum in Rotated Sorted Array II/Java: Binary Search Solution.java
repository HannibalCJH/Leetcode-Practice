public class Solution {
    // 时间复杂度O(logn)，最坏情况O(n)
    // 空间复杂度O(1)
    public int findMin(int[] nums) 
    {
        int min = nums[0];
        int left = 0, right = nums.length - 1;
        while(left <= right)
        {
            int mid = (left + right) / 2;
            if(nums[left] < nums[mid])
            {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            }
            else if(nums[left] > nums[mid])
            {
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }
            else
            {
                min = Math.min(min, nums[left++]);
            }
        }
        return min;    
    }
}
