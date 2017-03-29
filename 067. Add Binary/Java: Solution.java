public class Solution {
    // 时间复杂度O(max(m,n))，空间复杂度O(max(m,n))
    public String addBinary(String a, String b) 
    {
        int m = a.length() - 1, n = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(m >= 0 || n >= 0 || carry > 0)
        {
            int ch1 = m >= 0 ? a.charAt(m--) - '0' : 0;
            int ch2 = n >= 0 ? b.charAt(n--) - '0' : 0;
            int sum = ch1 + ch2 + carry;
            sb.insert(0, String.valueOf(sum % 2));
            carry = sum / 2;
        }
        return sb.toString();
    }
}
