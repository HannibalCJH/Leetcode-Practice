public class Solution {
    public int FindMin(int[] nums) 
    {
        int min = nums[0];
        int left = 0, right = nums.Length - 1;
        while(left <= right)
        {
            int mid = (left + right) / 2;
            if(nums[left] < nums[mid])
            {
                min = Math.Min(min, nums[left]);
                left = mid + 1;
            }
            else if(nums[left] > nums[mid])
            {
                min = Math.Min(min, nums[mid]);
                right = mid - 1;
            }
            else
            {
                min = Math.Min(min, nums[left++]);
            }
        }
        return min;
    }
}
