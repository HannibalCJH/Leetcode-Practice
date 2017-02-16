public class Solution {
    // 时间复杂度仍是O(n)，因为我们不会检查不存在于数组的数，而存在于数组的数也只会检查一次
    // 空间复杂度O(n)
    public int longestConsecutive(int[] nums) 
    {
        if(nums == null || nums.length == 0)
            return 0;
        // 把所有数加入集合中
        HashSet<Integer> set = new HashSet<Integer>();
        int max = 1;
        for(int num : nums)
        {
            set.add(num);
        }
        
        for(int i = 0; i <nums.length; i++)
        {
            int temp = nums[i];
            int tempMax = 1;
            // 找升序
            while(set.contains(++temp))
            {
                set.remove(temp);
                tempMax++;
            }
            // 找降序
            temp = nums[i];
            while(set.contains(--temp))
            {
                set.remove(temp);
                tempMax++;
            }
            max = Math.max(tempMax, max);
        }
        return max;
    }
}
