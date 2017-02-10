public class Solution {
    public void SortColors(int[] nums) 
    {
        int[] counts = new int[3];
        for(int i = 0; i < nums.Length; i++)
        {
            if(nums[i] == 0)
                counts[0]++;
            else if(nums[i] == 1)
                counts[1]++;
            else
                counts[2]++;
        }
        
        for(int i = 0; i < nums.Length; i++)
        {
            if(counts[0]-- > 0)
                nums[i] = 0;
            else if(counts[1]-- > 0)
                nums[i] = 1;
            else if(counts[2]-- > 0)
                nums[i] = 2;
        }
    }
}
