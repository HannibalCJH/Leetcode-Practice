public class Solution {
    // 时间复杂度O(n)，字符串拼接
    // 空间复杂度O(n)，字符串及单词
    public String numberToWords(int num) 
    {
        // 输入为0
        if(num == 0)
            return "Zero";
        // 构造字符串从数的低位开始
        // 处理百位，取后三位，比如123456%1000即456
        String result =  numberToWordsHelper(num % 1000);
        // 处理千位，注意要检查num%100是否大于0，如果等于0比如1000010，当中的部分省略不用打印
        num = num / 1000;
        if(num > 0 && num % 1000 > 0)
        {
            result = numberToWordsHelper(num % 1000) + "Thousand " + result;
        }
        // 处理百万位
        num = num / 1000;
        if(num > 0 && num % 1000 > 0)
        {
            result = numberToWordsHelper(num % 1000) + "Million " + result;
        }
        // 处理十亿位
        num = num / 1000;
        if(num > 0)
        {
            result = numberToWordsHelper(num % 1000) + "Billion " + result;
        }
        return result.trim();
    }
    // 每次处理的都是1~999的数，因为每次传入的都是num%1000
    public String numberToWordsHelper(int num)
    {
        String[] digitString = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teenString = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen", "Nineteen"};
        String[] tenString = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String result = "";
        // 大于99，则有百位
        if(num > 99)
        {
            result += digitString[num / 100] + " Hundred ";
        }
        // 处理10~19的数，比较特殊
        num = num % 100;
        if(num < 20 && num > 9)
        {
            result += teenString[num % 10] + " ";
        }
        else
        {
            if(num > 19)
            {
                result += tenString[num / 10] + " ";
            }
            num = num % 10;
            if(num > 0)
                result += digitString[num] + " ";
        }
        return result;
    }
}
