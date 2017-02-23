public class Solution {
    public int FindKthLargest(int[] nums, int k) 
    {
        return QuickSelect(nums, k - 1, 0, nums.Length - 1);
    }
    
    private int QuickSelect(int[] nums, int k, int left, int right)
    {
        int start = left, end = right;
        int pivot = nums[(left + right) / 2];
        while(start <= end)
        {
            while(nums[start] > pivot)
                start++;
            while(nums[end] < pivot)
                end--;
            if(start <= end)
            {
                Swap(nums, start, end);
                start++;
                end--;
            }
        }
        
        if(left < end && k <= end)
            QuickSelect(nums, k, left, end);
        else if(right > start && k >= start)
            QuickSelect(nums, k, start, right);
        return nums[k];
    }
    
    private void Swap(int[] nums, int x, int y)
    {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
