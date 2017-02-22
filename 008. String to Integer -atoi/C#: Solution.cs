public class Solution {
    public int MyAtoi(string str) 
    {
        str = str.Trim();
        if(str.Length == 0)
            return 0;
        
        int index = 0;
        bool negative = false;
        
        if(str[index] == '-')
        {
            negative = true;
            index++;
        }
        else if(str[index] == '+')
        {
            index++;
        }
        
        double result = 0;
        for(; index < str.Length; index++)
        {
            char cur = str[index];
            if(Char.IsDigit(cur))
            {
                result = result * 10 + (cur - '0');
            }
            else
                break;
        }
        
        if(negative)
            result = -result;
        
        if(result > Int32.MaxValue)
            result = Int32.MaxValue;
        if(result < Int32.MinValue)
            result = Int32.MinValue;
        return (int)result;
    }
}
