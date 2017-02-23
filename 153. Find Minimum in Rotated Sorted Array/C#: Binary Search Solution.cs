public class Solution {
    public int FindMin(int[] nums) 
    {
        int left = 0, right = nums.Length - 1;
        int min = nums[0];
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(nums[left] <= nums[mid])
            {
                min = Math.Min(min, nums[left]);
                left = mid + 1;
            }
            else
            {
                min = Math.Min(min, nums[mid]);
                right = mid - 1;
            }
        }
        return min;
    }
}
