public class Solution {
    // 时间复杂度O(logn)，空间复杂度O(1)
    public String convertToTitle(int n) 
    {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0)
        {
            n--;
            sb.insert(0, (char)(n % 26 + 'A'));
            n /= 26;
        }
        return sb.toString();
    }
    
    // 我的版本
    public String convertToTitle2(int n) 
    {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0)
        {
            int mod = n % 26;
            if(mod == 0)
            {
                mod = 26;
                n--;
            }
            
            sb.insert(0, (char)(mod - 1 + 'A'));
            n /= 26;
        }
        return sb.toString();
    }
}
