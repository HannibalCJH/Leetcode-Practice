public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public int[] TwoSum(int[] nums, int target) 
    {
        if(nums == null || nums.Length < 2)
            return new int[0];
        Dictionary<int, int> map = new Dictionary<int, int>();
        int[] result = new int[2];
        for(int i = 0; i < nums.Length; i++)
        {
            int key = target - nums[i];
            if(map.ContainsKey(key))
            {
                result[0] = map[key];
                result[1] = i;
                break;
            }
            // 注意C#中Dictionary.Add不能覆盖已存在键对应的值
            if(map.ContainsKey(nums[i]))
                map[nums[i]] = i;
            else
                map.Add(nums[i], i);
        }
        return result;
    }
}
