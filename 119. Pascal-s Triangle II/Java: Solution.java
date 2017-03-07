public class Solution {
    // 时间复杂度O(n^2)，空间复杂度O(n)
    public List<Integer> getRow(int rowIndex) 
    {
        List<Integer> cur = new ArrayList<>();
        // 加入第一个1
        cur.add(1);
        for(int i = 1; i < rowIndex + 1; i++)
        {
            // 从最后一位开始，这一层的第j个数是上一层的第j-1个数和第j个数相加
            // 如果正向计算的话会把上层的第j个数抹掉，变成了这一层的第j个数，这样算这一层第j+1个数时就会出错
            for(int j = i; j >= 1; j--)
            {
                // 最后一位直接加1
                if(j == i)
                {
                    cur.add(1);
                }
                else
                {
                    cur.set(j, cur.get(j - 1) + cur.get(j));
                }
            }
        }
        return cur;
    }
}
