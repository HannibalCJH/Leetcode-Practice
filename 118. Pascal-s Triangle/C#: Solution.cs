public class Solution {
    // 时间复杂度O(n^2)，空间复杂度O(n^2)
    public IList<IList<int>> Generate(int numRows) 
    {
        IList<IList<int>> result = new List<IList<int>>();
        for(int i = 0; i < numRows; i++)
        {
            IList<int> cur = new List<int>();
            for(int j = 0; j < i + 1; j++)
            {
                if(j == 0 || j == i)
                {
                    cur.Add(1);
                }
                else
                {
                    IList<int> upLevel = result[i - 1];
                    int upLeft = upLevel[j - 1], upRight = upLevel[j];
                    cur.Add(upLeft + upRight);
                }
            }
            result.Add(cur);
        }
        return result;
    }
}
