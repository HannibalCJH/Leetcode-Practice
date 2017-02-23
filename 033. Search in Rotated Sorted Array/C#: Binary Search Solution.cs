public class Solution {
    public int Search(int[] nums, int target) 
    {
        if(nums == null || nums.Length == 0)
            return -1;
        int left = 0, right = nums.Length - 1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[left] <= nums[mid])
            {
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else
            {
                if(nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
