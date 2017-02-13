public class Solution {
    public IList<IList<int>> ThreeSum(int[] nums) 
    {
        IList<IList<int>> result = new List<IList<int>>();
        // 排序使数组元素递增排列
        Array.Sort(nums);
        
        for(int i = 0; i < nums.Length - 2; i++)
        {
            // 第一个数如果大于0则整个和肯定也大于0
            if(nums[i] > 0)
                break;
            // 跳过相同元素
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int j = i + 1, k = nums.Length - 1;
            int target = -nums[i];
            while(j < k)
            {
                // 找到一个组合
                if(nums[j] + nums[k] == target)
                {
                    result.Add(new List<int>(){nums[i], nums[j], nums[k]});
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
                else if(nums[j] + nums[k] > target)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }
        return result;
    }
}
