public class Solution {
    public void WiggleSort(int[] nums) 
    {
        bool less = true;
        for(int i = 0; i < nums.Length - 1; i++)
        {
            if(less)
            {
                if(nums[i] > nums[i + 1])
                    Swap(nums, i, i + 1);
            }
            else
            {
                if(nums[i] < nums[i + 1])
                    Swap(nums, i, i + 1);
            }
            less = !less;
        }
    }
    
    private void Swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
