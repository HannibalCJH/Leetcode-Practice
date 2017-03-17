public class Solution {
    // 时间复杂度O(logn)，空间复杂度O(1)
    public int findPeakElement(int[] nums) 
    {
        int left = 0, right = nums.length - 1;
        while(left <= right)
        {
            // 找到峰值
            if(left == right)
                return left;
                
            int mid = (left + right) / 2;
            // 中点比右边小，那右半边肯定包含一个峰值
            // 这里指的右边不包含中点，因为我们比较了中点和它右边的点而且右边的点比较大，那可能的峰值最起码是右边这个大的点
            // 而不会是比右边点小的中点
            if(nums[mid] < nums[mid + 1])
            {
                left = mid + 1;
            }
            else
            {
                // 中点比右边大，那中点本身可能是峰值，所以左半边还是要包含中点
                right = mid;
            }
        }
        return 0;
    }
}
