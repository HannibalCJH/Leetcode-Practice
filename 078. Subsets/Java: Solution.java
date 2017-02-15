public class Solution {
    // 时间复杂度O(n2^n)，可能的子集有2^n个，每个里面有一个for循环
    // 空间复杂度O(n)，递归栈深度
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return result;
        dfs(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> cur, int[] nums, int step)
    {
        // 每次都加，需要输出的是所有可能的子集包括空集
        result.add(new ArrayList<Integer>(cur));
        
        if(step == nums.length)
            return;
        
        for(int i = step; i < nums.length; i++)
        {
            cur.add(nums[i]);
            dfs(result, cur, nums, i + 1);
            // 回溯
            cur.remove(cur.size() - 1);
        }
    }
}
