public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public int[] twoSum(int[] nums, int target) 
    {
        if(nums == null || nums.length < 2)
            return new int[0];
            
        int[] result = new int[2];
        // 哈希表，键为nums[i]，值为下标i
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            int key = target - nums[i];
            if(map.containsKey(key))
            {
                result[0] = map.get(key);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
