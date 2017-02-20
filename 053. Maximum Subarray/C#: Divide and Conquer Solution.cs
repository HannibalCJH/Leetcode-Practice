public class Solution {
    public int MaxSubArray(int[] nums) 
    {
        return SubArray(nums, 0, nums.Length - 1);
    }
    
    private int SubArray(int[] nums, int left, int right)
    {
        if(left == right)
            return nums[left];
        
        int mid = left + (right - left) / 2;
        int leftSum = SubArray(nums, left, mid);
        int rightSum = SubArray(nums, mid + 1, right);
        int midSum = MidSubArray(nums, left, mid, right);
        
        if(leftSum >= rightSum && leftSum >= midSum)
            return leftSum;
        if(rightSum >= leftSum && rightSum >= midSum)
            return rightSum;
        return midSum;
    }
    
    private int MidSubArray(int[] nums, int left, int mid, int right)
    {
        int leftSum = Int32.MinValue, rightSum = Int32.MinValue;
        int sum = 0;
        for(int i = mid; i >= left; i--)
        {
            sum += nums[i];
            leftSum = Math.Max(leftSum, sum);
        }
        
        sum = 0;
        for(int i = mid + 1; i <= right; i++)
        {
            sum += nums[i];
            rightSum = Math.Max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}
