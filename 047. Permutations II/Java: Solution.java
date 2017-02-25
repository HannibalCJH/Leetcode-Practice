public class Solution {
    // 时间复杂度O(n!)，空间复杂度O(n)
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        if(nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(new ArrayList<Integer>(), nums, visited);
        return result;
    }
    
    private void dfs(List<Integer> cur, int[] nums, boolean[] visited)
    {
        if(cur.size() == nums.length)
        {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                cur.add(nums[i]);
                dfs(cur, nums, visited);
                visited[i] = false;
                cur.remove(cur.size() - 1);
                // 每一层加的数要不同，跳过相同的数
                while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
            }
        }
    }
}
