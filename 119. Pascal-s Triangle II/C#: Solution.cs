public class Solution {
    // 时间复杂度O(n^2)，空间复杂度O(n)
    public IList<int> GetRow(int rowIndex) 
    {
        IList<int> cur = new List<int>();
        // 加入第一个1
        cur.Add(1);
        for(int i = 0; i < rowIndex + 1; i++)
        {
            for(int j = i; j >= 1; j--)
            {
                if(j == i)
                {
                    cur.Add(1);
                }
                else
                {
                    cur[j] = cur[j - 1] + cur[j];
                }
            }
        }
        return cur;
    }
}
