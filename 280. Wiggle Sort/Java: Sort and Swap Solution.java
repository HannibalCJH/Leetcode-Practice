public class Solution {
    // 时间复杂度O(nlogn)，空间复杂度O(1)
    public void wiggleSort(int[] nums) 
    {
        Arrays.sort(nums);
        for(int i = 2; i < nums.length; i += 2)
        {
            int temp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = temp;
        }
    }
}
