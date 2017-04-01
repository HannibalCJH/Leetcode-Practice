public class Solution {
    public int MinSubArrayLen(int s, int[] nums) 
    {
        if(nums == null || nums.Length == 0)
            return 0;
        
        int left = 0, right = 0;
        int sum = 0, minLength = nums.Length + 1;
        while(right < nums.Length)
        {
            sum += nums[right];
            while(sum >= s)
            {
                minLength = Math.Min(minLength, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return minLength == nums.Length + 1 ? 0 : minLength;
    }
}
