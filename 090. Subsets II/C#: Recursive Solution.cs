public class Solution {
    public IList<IList<int>> SubsetsWithDup(int[] nums) 
    {
        IList<IList<int>> result = new List<IList<int>>();
        if(nums == null || nums.Length == 0)
            return result;
        // 数组排序把相同数字排一起
        Array.Sort(nums);
        DFS(result, new List<int>(), nums, 0);
        return result;
    }
    
    private void DFS(IList<IList<int>> result, IList<int> cur, int[] nums, int step)
    {
        result.Add(new List<int>(cur));
        
        if(step == nums.Length)
        {
            return;
        }
        
        for(int i = step; i < nums.Length; i++)
        {
            // 在这一层中跳过重复数字
            if(i > step && nums[i] == nums[i - 1])
                continue;
            cur.Add(nums[i]);
            DFS(result, cur, nums, i + 1);
            cur.RemoveAt(cur.Count - 1);
        }
    }
}
