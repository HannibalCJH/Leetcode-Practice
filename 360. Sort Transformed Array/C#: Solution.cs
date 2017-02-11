public class Solution {
    public int[] SortTransformedArray(int[] nums, int a, int b, int c) 
    {
        if(nums == null || nums.Length == 0)
            return nums;
        int length = nums.Length;
        int[] result = new int[length];
        int left = 0, right = length - 1;
        int index = a >= 0 ? length - 1 : 0;
        while(left <= right)
        {
            int leftNum = Calculate(nums[left], a, b, c), rightNum = Calculate(nums[right], a, b, c);
            if(a >= 0)
            {
                if(leftNum <= rightNum)
                {
                    result[index--] = rightNum;
                    right--;
                }
                else
                {
                    result[index--] = leftNum;
                    left++;
                }
            }
            else
            {
                if(leftNum <= rightNum)
                {
                    result[index++] = leftNum;
                    left++;
                }
                else
                {
                    result[index++] = rightNum;
                    right--;
                }
            }
        }
        return result;
    }
    
    private int Calculate(int x, int a, int b, int c)
    {
        return a * x * x + b * x + c;
    }
}
