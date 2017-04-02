public class Solution {
    // 时间复杂度O(n*(2^k))，n为candidates的长度，k为变型后的candidates长度
    // 比如[2,3,5,7]，target为7，变型后的数组为[2,2,2,2,3,3,3,5,5,7]，然后就可以利用Subsets的原理去分析时间复杂度
    // 空间复杂度O(2^k)，递归栈空间
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return result;
        
        dfs(result, new ArrayList<Integer>(), candidates, target, 0, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int sum, int step)
    {
        // 数组中的数都是正数，当目前的和已经大于等于目标就不用再继续递归了，因为接下来不论加哪个数都会大于目标
        if(sum >= target)
        {
            // 等于目标就加入结果列表
            if(sum == target)
                result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for(int i = step; i < candidates.length; i++)
        {
            cur.add(candidates[i]);
            // 和Subsets类型题目不同的是，这道题允许重复选择某一个数，所以我们传入下一层递归的step依旧是i而不是i+1跳到下一个数，
            // 也就是我们尽可能的多次取当前的数candidates[i]，看是不是有可能凑出目标数
            dfs(result, cur, candidates, target, sum + candidates[i], i);
            // 回溯
            cur.remove(cur.size() - 1);
        }
    }
}
