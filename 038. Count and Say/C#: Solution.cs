public class Solution {
    // 时间复杂度O(n!)，空间复杂度O(n)
    public string CountAndSay(int n) 
    {
        StringBuilder sb = new StringBuilder("1");
        int count = 1;
        // 迭代n-1次
        for(int i = 1; i < n; i++)
        {
            // current为上一轮创建的第i-1个字符串
            String current = sb.ToString();
            // 重置StringBuilder
            sb = new StringBuilder("");
            // 扫字符串计数
            for(int j = 0; j < current.Length; j++)
            {
                // 重置计数器
                count = 1;
                // 当前字符和下一个字符相同
                while(j + 1 < current.Length && current[j] == current[j+1])
                {
                    count++;
                    j++;
                }
                // 字符不相同
                sb.Append(count);
                sb.Append(current[j]);
            }
        }
        return sb.ToString();
    }
}
