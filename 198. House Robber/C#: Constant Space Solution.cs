public class Solution {
    public int Rob(int[] nums) 
    {
        int first = 0, second = 0;
        for(int i = 0; i < nums.Length; i++)
        {
            int cur = Math.Max(first + nums[i], second);
            first = second;
            second = cur;
        }
        return second;
    }
}
