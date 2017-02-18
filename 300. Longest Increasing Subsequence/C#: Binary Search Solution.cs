public class Solution {
    public int LengthOfLIS(int[] nums) 
    {
        if(nums == null || nums.Length == 0)
            return 0;
        
        int[] tails = new int[nums.Length];
        tails[0] = nums[0];
        int length = 0;
        for(int i = 1; i < nums.Length; i++)
        {
            // 比最小的末尾还小，直接更新最小末尾
            if(nums[i] < tails[0])
                tails[0] = nums[i];
            else if(nums[i] > tails[length])
                tails[++length] = nums[i];
            else
            {
                // 找刚好大于
                tails[BinarySearch(tails, 0, length, nums[i])] = nums[i];
            }
        }
        return length + 1;
    }
    
    private int BinarySearch(int[] tails, int left, int right, int target)
    {
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if(tails[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        return left;
    }
}
