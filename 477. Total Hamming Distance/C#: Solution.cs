public class Solution {
    public int TotalHammingDistance(int[] nums) 
    {
        int length = nums.Length;
        int n = 32;
        int[] bitmap = new int[n];
        for(int i = 0; i < length; i++)
        {
            for(int j = 0; j < n; j++)
            {
                bitmap[j] += nums[i] & 1;
                nums[i] >>= 1;
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            count += bitmap[i] * (length - bitmap[i]);
        }
        return count;
    }
}
