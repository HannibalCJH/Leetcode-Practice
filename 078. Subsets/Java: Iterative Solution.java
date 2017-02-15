public class Solution {
    // 时间复杂度O(n*(2^(n+1))，空间复杂度O(2^n)
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return result;
            
        List<Integer> cur = new ArrayList<Integer>();
        // 加入空集
        result.add(cur);
        // 注意里外层循环不能颠倒
        for(int i = 0; i < nums.length; i++)
        {
            List<List<Integer>> temp = new ArrayList<>();
            // 对结果集中的元素，每次只加nums[i]
            // for耗时O(2^n)
            for(List<Integer> sub : result)
            {
                cur = new ArrayList<Integer>(sub);
                cur.add(nums[i]);
                temp.add(cur);
            }
            // addAll耗时O(2^n)
            result.addAll(temp);
        }
        return result;
    }
}
