public class Solution {
    // 这道题和Subsets II几乎一样，只是我们需要的结果列表中只包含和为target的子数组
    // 时间复杂度O(nlogn + n*(2^n))
    // 空间复杂度O(2^n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return result;
            
        Arrays.sort(candidates);
        dfs(result, new ArrayList<Integer>(), candidates, target, 0, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int sum, int step)
    {
        if(sum >= target)
        {
            if(sum == target)
                result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for(int i = step; i < candidates.length; i++)
        {
            cur.add(candidates[i]);
            dfs(result, cur, candidates, target, sum + candidates[i], i + 1);
            cur.remove(cur.size() - 1);
            while(i < candidates.length - 1 && candidates[i] == candidates[i + 1]) i++;
        }
    }
}
