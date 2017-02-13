public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int[] twoSum(int[] numbers, int target) 
    {
        if(numbers == null || numbers.length < 2)
            return new int[0];
            
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        // 双指针
        while(left < right)
        {
            int sum = numbers[left] + numbers[right];
            if(sum == target)
            {
                // 根据题意：returned answers (both index1 and index2) are not zero-based
                // 返回的下标从1开始而不是0
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            else if(sum > target)
            {
                right--;
            }
            else
            {
                left++;
            }
        }
        return result;
    }
}
