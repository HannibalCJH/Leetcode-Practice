public class Solution {
    public int LongestConsecutive(int[] nums) 
    {
        if(nums == null || nums.Length == 0)
            return 0;
            
        HashSet<int> set = new HashSet<int>();
        int max = 1;
        foreach(int num in nums)
        {
            set.Add(num);
        }
        
        for(int i = 0; i < nums.Length; i++)
        {
            int tempMax = 1;
            int temp = nums[i];
            // 寻找升序
            while(set.Contains(++temp))
            {
                set.Remove(temp);
                tempMax++;
            }
            
            // 寻找降序
            temp = nums[i];
            while(set.Contains(--temp))
            {
                set.Remove(temp);
                tempMax++;
            }
            max = Math.Max(tempMax, max);
        }
        return max;
    }
}
