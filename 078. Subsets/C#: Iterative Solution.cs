public class Solution {
    public IList<IList<int>> Subsets(int[] nums) 
    {
        IList<IList<int>> result = new List<IList<int>>();
        if(nums == null || nums.Length == 0)
            return result;
            
        IList<int> cur = new List<int>();
        // 加空集
        result.Add(cur);
        for(int i = 0; i < nums.Length; i++)
        {
            IList<IList<int>> temp = new List<IList<int>>();
            foreach(IList<int> sub in result)
            {
                cur = new List<int>(sub);
                cur.Add(nums[i]);
                temp.Add(cur);
            }
            
            foreach(IList<int> sub in temp)
            {
                result.Add(sub);
            }
        }
        return result;
    }
}
