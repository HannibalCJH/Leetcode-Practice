public class Solution {
    public int ThirdMax(int[] nums) 
    {
        long first = Int64.MinValue, second = Int64.MinValue, third = Int64.MinValue;
        foreach(int num in nums)
        {
            if(num == first || num == second || num == third)
                continue;
            if(num > first)
            {
                third = second;
                second = first;
                first = num;
            }
            else if(num > second)
            {
                third = second;
                second = num;
            }
            else if(num > third)
            {
                third = num;
            }
        }
        return third == Int64.MinValue ? (int)first : (int)third;
    }
}
