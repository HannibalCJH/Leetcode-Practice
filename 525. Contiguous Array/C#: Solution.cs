public class Solution {
    public int FindMaxLength(int[] nums) 
    {
        Dictionary<int, int> map = new Dictionary<int, int>();
        map.Add(0, -1);
        int count = 0, maxLength = 0;
        for(int i = 0; i < nums.Length; i++)
        {
            count += (nums[i] == 1 ? 1 : -1);
            if(map.ContainsKey(count))
            {
                maxLength = Math.Max(maxLength, i - map[count]);
            }
            else
            {
                map.Add(count, i);
            }
        }
        return maxLength;
    }
}
