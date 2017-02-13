public class Solution {
    // 二分搜索法
    // 时间复杂度O(nlogn)，空间复杂度O(1)
    public int[] twoSum(int[] numbers, int target) 
    {
        if(numbers == null || numbers.length < 2)
            return new int[0];
        int[] result = new int[2];
        for(int i = 0; i < numbers.length - 1; i++)
        {
            int gap = target - numbers[i];
            int secondIndex = binarySearch(numbers, gap, i + 1);
            if(secondIndex == i || secondIndex == -1)
                continue;
            else
            {
                result[0] = i < secondIndex ? i + 1 : secondIndex + 1;
                result[1] = i > secondIndex ? i + 1 : secondIndex + 1;
                break;
            }
        }
        return result;
    }
    
    // 二分搜索
    private int binarySearch(int[] numbers, int target, int left)
    {
        int right = numbers.length - 1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(numbers[mid] == target)
                return mid;
            else if(numbers[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        // 没找到
        return -1;
    }
}
