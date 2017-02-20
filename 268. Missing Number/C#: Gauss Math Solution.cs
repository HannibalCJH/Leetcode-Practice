public class Solution {
    public int MissingNumber(int[] nums) 
    {
        int n = nums.Length;
        int sum = (0 + n) * (n + 1) / 2;
        int temp = 0;
        foreach(int num in nums)
        {
            temp += num;
        }
        return sum - temp;
    }
}
