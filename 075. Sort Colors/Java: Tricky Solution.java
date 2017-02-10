public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    // 取巧做法，覆盖颜色
	public void sortColors(int[] nums) 
	{
        int[] counts = new int[3];
        // 先扫一遍，分别记下各种颜色出现的次数
        for(int i = 0; i < nums.length; i++)
        {
        	if(nums[i] == 0)
        		counts[0]++;
        	else if(nums[i] == 1)
        		counts[1]++;
        	else
        		counts[2]++;
        }
        
        for(int i = 0; i < nums.length; i++)
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
