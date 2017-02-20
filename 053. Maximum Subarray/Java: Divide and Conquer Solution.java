public class Solution {
    /*
    分治法
    最大的子序列和在选定一个中点后存在以下三种情况
    1. 最大子序列和在左半边
    2. 最大子序列和在右半边
    3. 最大子序列跨越中点
    前两种情况可以递归调用左右半边的序列。第三中情况可以从中点往左边扫得到一个左边最大值，
    再从中点往右扫得到一个右边最大值，然后把这两者加起来返回即可
    
    T(n) = 2*T(n/2) + O(n)
    时间复杂度O(nlogn)，空间复杂度O(logn)，递归栈空间
    */
    public int maxSubArray(int[] nums) 
    {
        int maxSum = subArray(nums, 0, nums.length - 1);
        return maxSum;
    }
    
    private int subArray(int[] nums, int left, int right)
    {
        if(left == right)
            return nums[left];
        
        int mid = left + (right - left) / 2;
        // 左半边的最大值
        int leftSum = subArray(nums, left, mid);
        // 右半边的最大值
        int rightSum = subArray(nums, mid + 1, right);
        // 跨越中点的最大值
        int middleSum = midSubArray(nums, left, mid, right);
        
        if(leftSum >= rightSum && leftSum >= middleSum)
            return leftSum;
            
        if(rightSum >= leftSum && rightSum >= middleSum)
            return rightSum;
            
        return middleSum;
    }
    
    private int midSubArray(int[] nums, int left, int mid, int right)
    {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        // 从中点往左边扫，找左边最大和
        int sum = 0;
        for(int i = mid; i >= left; i--)
        {
            sum += nums[i];
            if(leftSum < sum)
                leftSum = sum;
        }
        // 从中点往右边扫，找右边最大和
        sum = 0;
        for(int j = mid + 1; j <= right; j++)
        {
            sum += nums[j];
            if(rightSum < sum)
                rightSum = sum;
        }
        // 返回左右两边之和
        return leftSum + rightSum;
    }
}
