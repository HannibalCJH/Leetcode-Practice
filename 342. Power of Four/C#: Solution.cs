public class Solution {
    public bool IsPowerOfFour(int num) 
    {
        long power = 1;
        while(power < num)
        {
            power *= 4;
        }
        return (int)power == num;
    }
}
