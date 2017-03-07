public class Solution {
    // 时间复杂度O(n^2)，空间复杂度O(n^2)
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < numRows; i++)
        {
            List<Integer> cur = new ArrayList<>();
            for(int j = 0; j < i + 1; j++)
            {
                // 第一个和最后一个元素为1
                if(j == 0 || j == i)
                {
                    cur.add(1);
                }
                else
                {
                    // 上一层的元素
                    List<Integer> upLevel = result.get(i - 1);
                    int upLeft = upLevel.get(j - 1), upRight = upLevel.get(j);
                    cur.add(upLeft + upRight);
                }
            }
            result.add(cur);
        }
        return result;
    }
}
