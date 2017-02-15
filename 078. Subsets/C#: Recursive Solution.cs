public class Solution {
    public IList<IList<int>> Subsets(int[] nums) 
    {
        IList<IList<int>> result = new List<IList<int>>();
        if(nums == null || nums.Length == 0)
            return result;
        DFS(result, new List<int>(), nums, 0);
        return result;
    }
    
    private void DFS(IList<IList<int>> result, IList<int> cur, int[] nums, int step)
    {
        result.Add(new List<int>(cur));
        
        if(step == nums.Length)
            return;
            
        for(int i = step; i < nums.Length; i++)
        {
            cur.Add(nums[i]);
            DFS(result, cur, nums, i + 1);
            cur.RemoveAt(cur.Count - 1);
        }
    }
}
