public class Solution {
    public int SplitArray(int[] nums, int m) 
    {
        int max = 0;
        long sum = 0;
        foreach(int num in nums)
        {
            sum += num;
            max = Math.Max(num, max);
        }
        
        long left = max, right = sum;
        while(left <= right)
        {
            long mid = (left + right) / 2;
            if(Valid(nums, mid, m))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return (int)left;
    }
    
    private bool Valid(int[] nums, long sum, int m)
    {
        long total = 0;
        int count = 1;
        foreach(int num in nums)
        {
            total += num;
            if(total > sum)
            {
                count++;
                total = num;
                if(count > m)
                    return false;
            }
        }
        return true;
    }
}
