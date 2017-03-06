public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int thirdMax(int[] nums) 
    {
        Integer first = null, second = null, third = null;
        for(Integer num : nums)
        {
            // 当前的数和任意一个前三的数相等就跳过，我们要找的是不同的数，相同的数不会改变前三的数
            if(num.equals(first) || num.equals(second) || num.equals(third))
                continue;
            if(first == null || num > first)
            {
                third = second;
                second = first;
                first = num;
            }
            else if(second == null || num > second)
            {
                third = second;
                second = num;
            }
            else if(third == null || num > third)
            {
                third = num;
            }
        }
        return third == null ? first : third;
    }
}
