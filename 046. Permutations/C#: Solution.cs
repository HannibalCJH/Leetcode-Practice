public class Solution {
    IList<IList<int>> result = new List<IList<int>>();
    
    public IList<IList<int>> Permute(int[] nums) 
    {
        if(nums == null || nums.Length == 0)
            return result;
            
        bool[] visited = new bool[nums.Length];
        DFS(new List<int>(), nums, visited);
        return result;
    }
    
    private void DFS(IList<int> cur, int[] nums, bool[] visited)
    {
        if(cur.Count == nums.Length)
        {
            result.Add(new List<int>(cur));
            return;
        }
        
        for(int i = 0; i < nums.Length; i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                cur.Add(nums[i]);
                DFS(cur, nums, visited);
                visited[i] = false;
                cur.RemoveAt(cur.Count - 1);
            }
        }
    }
}
