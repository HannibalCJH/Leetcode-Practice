public class Solution {
    public IList<IList<int>> CombinationSum(int[] candidates, int target) 
    {
        IList<IList<int>> result = new List<IList<int>>();
        if(candidates == null || candidates.Length == 0)
            return result;
        
        DFS(result, new List<int>(), candidates, target, 0, 0);
        return result;
    }
    
    private void DFS(IList<IList<int>> result, IList<int> cur, int[] candidates, int target, int sum, int step)
    {
        if(sum >= target)
        {
            if(sum == target)
                result.Add(new List<int>(cur));
            return;
        }
        
        for(int i = step; i < candidates.Length; i++)
        {
            cur.Add(candidates[i]);
            DFS(result, cur, candidates, target, sum + candidates[i], i);
            cur.RemoveAt(cur.Count - 1);
        }
    }
}
