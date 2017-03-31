public class Solution {
    // 时间复杂度O(mn+(m+n))
    // 空间复杂度O(m+n)
    public String multiply(String num1, String num2) 
	{
        if(num1 == null || num2 == null) 
        	return null;
        int m = num1.length(), n = num2.length();
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
                int product = carry + result[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j + 1] = product % 10;
                carry = product / 10;
            }
            // 把最后的carry位加上
            result[i + j + 1] = carry;
        }
        StringBuilder sb = new StringBuilder();
        i = 0;
        // 跳过前面无用的0
        while(i < length - 1 && result[i] == 0)
        {
            i++;
        }
        for(; i < length; i++)
            sb.append(result[i]);
        return sb.toString();
    }
}
