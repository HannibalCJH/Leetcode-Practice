public class Solution {
    public int FindPeakElement(int[] nums) 
    {
        int left = 0, right = nums.Length - 1;
        while(left <= right)
        {
            if(left == right)
                return left;
                
            int mid = (left + right) / 2;
            if(nums[mid] < nums[mid + 1])
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        return 0;
    }
}
