public class Solution {
    // 时间复杂度O(n4^n)，空间复杂度O(n)
    List<String> result = new ArrayList<String>();
    
    public List<String> addOperators(String num, int target) 
    {
        if(num == null || num.length() == 0)
            return result;
        dfs(num, target, 0, 0, 0, "");
        return result;
    }
    
    private void dfs(String num, int target, int start, long sum, long preVal, String cur)
    {
        if(start == num.length())
        {
            // 找到结果
            if(sum == target)
                result.add(cur);
            return;
        }
        
        // 截取下一个数字的时候用的是substring(start, i)，不包括i位置的字符
        // 而且i用作substring的结尾下标所以要以start+1开始
        for(int i = start + 1; i <= num.length(); i++)
        {
            // 用long不用int，因为是从字符串转换过来，可能超出int的范围
            long val = Long.parseLong(num.substring(start, i));
            // 以0为前缀的数字不采用，比如"09"
            if(num.charAt(start) == '0' && i > start + 1)
                break;
            // 第一次只加数字，这样就不会出现"+9+8-7"的结果
            if(start == 0)
                dfs(num, target, i, val, val, cur + val);
            else
            {
                // 加号
                dfs(num, target, i, sum + val, val, cur + "+" + val);
                // 减号
                dfs(num, target, i, sum - val, -val, cur + "-" + val);
                // 乘号，preVal是前面连续相乘的乘积
                // 比如前面的字符串是3+4*5*6，那么sum代表的是这个表达式的和，preVal代表的是4*5*6，
                // 那么我们要乘以当前的数字，假设为7，我们不能直接拿sum也就是3+4*5*6去乘以7，
                // 而是应该sum-preVal变成只剩下3，然后preVal*7即4*5*6*7，再把这两者加起来
                dfs(num, target, i, sum - preVal + preVal * val, preVal * val, cur + "*" + val);
            }
        }
    }
}
