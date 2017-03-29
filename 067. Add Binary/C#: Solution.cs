public class Solution {
    public string AddBinary(string a, string b) 
    {
        int m = a.Length - 1, n = b.Length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(m >= 0 || n >= 0 || carry > 0)
        {
            int ch1 = m >= 0 ? a[m--] - '0' : 0;
            int ch2 = n >= 0 ? b[n--] - '0' : 0;
            int sum = ch1 + ch2 + carry;
            sb.Insert(0, (char)(sum % 2 + '0'));
            carry = sum / 2;
        }
        return sb.ToString();
    }
}
