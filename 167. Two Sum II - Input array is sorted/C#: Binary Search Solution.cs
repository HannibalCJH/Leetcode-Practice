public class Solution {
    public int[] TwoSum(int[] numbers, int target) 
    {
        if(numbers == null || numbers.Length < 2)
            return new int[0];
            
        int[] result = new int[2];
        for(int i = 0; i < numbers.Length - 1; i++)
        {
            int gap = target - numbers[i];
            int secondIndex = BinarySearch(numbers, gap, i + 1);
            if(secondIndex == i || secondIndex == -1)
                continue;
            else
            {
                result[0] = i < secondIndex ? i + 1 : secondIndex + 1;
                result[1] = i > secondIndex ? i + 1 : secondIndex + 1;
            }
        }
        return result;
    }
    
    private int BinarySearch(int[] numbers, int target, int left)
    {
        int right = numbers.Length - 1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(numbers[mid] == target)
            {
                return mid;
            }
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
