public class Solution {
    public void NextPermutation(int[] nums) 
    {
        if(nums == null || nums.Length < 2)
            return;
        
        int i;
        for(i = nums.Length - 2; i >= 0; i--)
        {
            if(nums[i + 1] > nums[i])
                break;
        }
        
        if(i >= 0)
        {
            for(int j = nums.Length - 1; j >= 0; j--)
            {
                if(nums[j] > nums[i])
                {
                    Swap(nums, i, j);
                    break;
                }
            }
        }
        Reverse(nums, i + 1, nums.Length - 1);
    }
    
    private void Swap(int[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    private void Reverse(int[] nums, int left, int right)
    {
        while(left < right)
        {
            Swap(nums, left++, right--);
        }
    }
}
