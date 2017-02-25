public class Solution {
    // Digital Root
    // 时间复杂度O(1)，空间复杂度O(1)
    public int addDigits(int num) 
    {
        return 1 + ((num - 1) % 9);    
    }
}
