public class Solution {
    public int MissingNumber(int[] nums) 
    {
        int missing = 0, i;
        for(i = 0; i < nums.Length; i++)
            missing ^= i ^ nums[i];
        return missing ^ i;
    }
}
