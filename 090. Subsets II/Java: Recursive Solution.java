public class Solution {
    // 时间复杂度O(n2^n)，空间复杂度O(n)
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        // 数组排序，把相同数字排在一起
        Arrays.sort(nums);
        dfs(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> cur, int[] nums, int step)
    {
        result.add(new ArrayList<Integer>(cur));
        
        if(step == nums.length)
        {
            return;
        }
        
        for(int i = step; i < nums.length; i++)
        {
            // 在这一层中如果当前的数和上一个数是相同的就跳过，避免产生重复的子集
            if(i > step && nums[i] == nums[i - 1])
                continue;
            cur.add(nums[i]);
            dfs(result, cur, nums, i + 1);
            // 回溯
            cur.remove(cur.size() - 1);
        }
    }
}
