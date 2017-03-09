public class Solution {
    // 参考http://www.xuebuyuan.com/2158451.html的表格解释，非常有助于理解
    // 沿用DP思想，优化空间复杂度
    // 时间复杂度O(n^2)，空间复杂度O(n)
    public int longestPalindromeSubseq(String s) 
    {
        int n = s.length();
        // 根据原来的DP方案，参考链接中的表格，其实我们只需要保存下一行数据即可然后推算出这一行后轮换一下，即把当前行的数据赋给下面一行，
        // 但同时我们也发现，其实只要保存一下要被覆盖的当前元素，我们完全可以用一个一维数组进行保存，而不是有两个数组curLevel和nextLevel
        int[] row = new int[n];
        // 记录当前将要被修改元素的数据，用作递推时上一层元素的左下角元素，实例参考链接中的表格
        int bottomLeft = 0;
        // 所以我们采取自底向上的构建方法，根据转移方程我们也可以看出，我们需要先完成i+1行的构建才能递推回第i行
        for(int i = n - 1; i >= 0; i--)
        {
            // 初始化bottomLeft为这一行的第一个元素，这个时候row[i]还没有被覆盖为1，依然是下一行时的元素，用来作为左下角元素
            bottomLeft = row[i];
            // 覆盖对角线上的元素为1即只有一个元素的情况
            row[i] = 1;
            for(int j = i + 1; j < n; j++)
            {
                // 保存当前将要被修改的元素
                int temp = row[j];
                // 首尾两个字符相同，那就是被首尾夹着的子串的最大回文子序列长度加2，很好理解，
                // 就是i+1到j-1位置的最大回文子序列长度加上首尾相同两个字符
                if(s.charAt(i) == s.charAt(j))
                    row[j] = bottomLeft + 2;
                else
                    // 当首尾字符不相同，我们要不选择包括进首字符，要不就选择包括进末尾字符，选长度大的就行
                    row[j] = Math.max(row[j], row[j - 1]);
                // 左下角元素更新为当前位置被改掉之前的元素
                bottomLeft = temp;
            }
        }
        // 返回从0到n-1也就是整个字符串范围下的最大回文子序列的长度
        return row[n - 1];
    }
}
