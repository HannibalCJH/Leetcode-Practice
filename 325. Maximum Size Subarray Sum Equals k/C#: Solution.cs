public class Solution {
    public int MaxSubArrayLen(int[] nums, int k) 
    {
        Dictionary<int, int> map = new Dictionary<int, int>();
        int max = 0, sum = 0;
        map.Add(0, -1);
        for(int i = 0; i < nums.Length; i++)
        {
            sum += nums[i];
            if(map.ContainsKey(sum - k))
                max = Math.Max(max, i - map[sum - k]);
            if(!map.ContainsKey(sum))
                map.Add(sum, i);
        }
        return max;
    }
}
