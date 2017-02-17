public class Solution {
    IList<string> result = new List<string>();
    
    public IList<string> AddOperators(string num, int target) 
    {
        if(num == null || num.Length == 0)
            return result;
        DFS(num, target, 0, 0, 0, "");
        return result;
    }
    
    private void DFS(string num, int target, int start, long sum, long preVal, string cur)
    {
        if(start == num.Length)
        {
            if(sum == target)
                result.Add(cur);
            return;
        }
        // i代表截取数字的长度
        for(int i = 1; i <= num.Length - start; i++)
        {
            // 取得下一个数字
            long val = Int64.Parse(num.Substring(start, i));
            // 不能以0作为数字的前缀，除非是它本身
            if(num[start] == '0' && i > 1)
                break;
            // 第一个数前面不加运算符
            if(start == 0)
            {
                DFS(num, target, start + i, val, val, cur + val);
            }
            else
            {
                // 加法
                DFS(num, target, start + i, sum + val, val, cur + "+" + val);
                // 减法
                DFS(num, target, start + i, sum - val, -val, cur + "-" + val);
                // 乘法
                DFS(num, target, start + i, sum - preVal + preVal * val, preVal * val, cur + "*" + val);
            }
        }
    }
}
