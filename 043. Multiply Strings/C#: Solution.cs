public class Solution {
    public string Multiply(string num1, string num2) 
    {
        if(num1 == null || num2 == null) 
            return null;
        int m = num1.Length, n = num2.Length;
        // 结果的位数最多可能是两个乘数位数之和
        int length = m + n;
        int[] result = new int[length];
        int carry = 0, i = 0, j = 0;
        for(i = m - 1; i >= 0; i--)
        {
            // 先置carry位为0
            carry = 0;
            for(j = n - 1; j >= 0; j--)
            {
                // 每一位的乘积，等于之前这一位的结果，加上carry，再加上这一位和乘数的乘积
                int product = carry + result[i + j + 1] + (num1[i] - '0') * (num2[j] - '0');
                result[i + j + 1] = product % 10;
                carry = product / 10;
            }
            // 把最后的carry位加上
            result[i + j + 1] = carry;
        }
        StringBuilder sb = new StringBuilder();
        i = 0;
        // 跳过前面无用的0，注意我们要保留最后一位即使是0，所以判断条件为i < length - 1
        while(i < length - 1 && result[i] == 0)
        {
            i++;
        }
        for(; i < length; i++)
            sb.Append(result[i]);
        return sb.ToString();
    }
}
