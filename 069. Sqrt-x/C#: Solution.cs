public class Solution {
    public int MySqrt(int x) 
    {
        long left = 0, right = x / 2 + 1;
        while(left <= right)
        {
            long mid = (left + right) / 2;
            long square = mid * mid;
            if(square == x)
                return (int)mid;
            else if(square < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return (int)right;
    }
}
