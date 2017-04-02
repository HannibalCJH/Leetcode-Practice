public class Solution {
    public IList<IList<int>> CombinationSum2(int[] candidates, int target) 
    {
        IList<IList<int>> result = new List<IList<int>>();
        if(candidates == null || candidates.Length == 0)
            return result;
            
        Array.Sort(candidates);
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
            DFS(result, cur, candidates, target, sum + candidates[i], i + 1);
            cur.RemoveAt(cur.Count - 1);
            while(i < candidates.Length - 1 && candidates[i] == candidates[i + 1]) i++;
        }
    }
}
