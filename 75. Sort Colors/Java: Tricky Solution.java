public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    // 取巧做法，覆盖颜色
	public void sortColors(int[] nums) 
	{
        int[] countColors = new int[3];
        // 先扫一遍，分别记下各种颜色出现的次数
        for(int i=0;i<nums.length;i++)
        {
        	if(nums[i] == 0)
        		countColors[0]++;
        	else if(nums[i] == 1)
        		countColors[1]++;
        	else
        		countColors[2]++;
        }
        
        int index = 0;
        // 再扫一遍，根据各种颜色覆盖原数组
        while(index < nums.length)
        {
        	for(int i = 0; i < 3; i++)
        	{
        		while(countColors[i] > 0)
            	{
            		nums[index++] = i;
            		countColors[i]--;
            	}
        	}
        }
    }
}
