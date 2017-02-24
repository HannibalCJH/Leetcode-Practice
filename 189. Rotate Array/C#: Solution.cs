public class Solution {
    public void Rotate(int[] nums, int k) 
    {
        if(nums == null || nums.Length == 0)
            return;
            
        int length = nums.Length;
        Swap(nums, 0, length - 1);
        
        int step = k % length;
        Swap(nums, 0, step - 1);
        Swap(nums, step, length - 1);
    }
    
    private void Swap(int[] nums, int left, int right)
    {
        while(left < right)
        {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
