public class Solution {
    // 时间复杂度O(nlogn)，空间复杂度O(1)
    public int missingNumber(int[] nums) 
    {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            // 下标和数符合则缺的数在右边
            if(nums[mid] == mid)
            {
                left = mid + 1;
            }
            // 不然在左边
            else
            {
                right = mid - 1;
            }
        }
        return nums[left] == left ? left + 1 : left;
    }
}
