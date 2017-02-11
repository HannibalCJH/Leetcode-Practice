public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    // 数学问题：当a>0时抛物线开口向下，a<0则开口向上
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) 
    {
        if(nums == null || nums.length == 0)
            return nums;
        int length = nums.length;
        int[] result = new int[length];
        int left = 0, right = length - 1;
        int index = a >= 0 ? length - 1 : 0;
        // 类似归并排序，分别从左右两端向中间归并
        while(left <= right)
        {
            int leftNum = calculate(nums[left], a, b, c), rightNum = calculate(nums[right], a, b, c);
            // 开口向上则从后往前放，a=0不影响
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
            // 开口向下则从前往后放
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
    
    private int calculate(int x, int a, int b, int c)
    {
        return a * x * x + b * x + c;
    }
}
