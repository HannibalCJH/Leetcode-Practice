public class Solution {
    public string NumberToWords(int num) 
    {
        if(num == 0)
            return "Zero";
        string result = NumberToWordsHelper(num % 1000);
        num /= 1000;
        if(num > 0 && num % 1000 > 0)
        {
            result = NumberToWordsHelper(num % 1000) + "Thousand " + result;
        }
        num /= 1000;
        if(num > 0 && num % 1000 > 0)
        {
            result = NumberToWordsHelper(num % 1000) + "Million " + result;
        }
        num /= 1000;
        if(num > 0 && num % 1000 > 0)
        {
            result = NumberToWordsHelper(num % 1000) + "Billion " + result;
        }
        return result.Trim();
    }
    
    // 处理1~999
    private string NumberToWordsHelper(int num)
    {
        string[] digits = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        string[] teens = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen", "Nineteen"};
        string[] tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        StringBuilder sb = new StringBuilder();
        if(num > 99)
        {
            sb.Append(digits[num / 100] + " Hundred ");
        }
        num %= 100;
        if(num >=10 && num <= 19)
        {
            sb.Append(teens[num % 10] + " ");
        }
        else
        {
            if(num > 19)
            {
                sb.Append(tens[num / 10] + " ");
            }
            num %= 10;
            if(num > 0)
            {
                sb.Append(digits[num] + " ");
            }
        }
        return sb.ToString();
    }
}
