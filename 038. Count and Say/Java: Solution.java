public class Solution {
    // 时间复杂度O(n!)，空间复杂度O(n)
    public String countAndSay(int n) 
    {
        StringBuilder sb = new StringBuilder("1");
        int count = 1;
        // 第一个已经初始化，只需迭代n-1次
        for(int i = 1; i < n; i++)
        {
            // 这次要遍历的字符串，即上一轮生成的第i-1个字符串
            String current = sb.toString();
            // 每次迭代后重置为空
            sb = new StringBuilder("");
            for(int j = 0; j < current.length(); j++)
            {
                // 重置计数器
                count = 1;
                // 当前字符和下一个字符相同
                // 这里不能用if() continue，不然会是count被重置为1，
                while(j + 1 < current.length() && current.charAt(j) == current.charAt(j + 1))
                {
                    count++;
                    j++;
                }
                // 当前字符串和下一个不同，则把计数器和当前字符加入sb
                sb.append(count);
                sb.append(current.charAt(j));
            }
        }
        return sb.toString();
    }
}
