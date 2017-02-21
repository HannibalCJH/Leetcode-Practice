public class Solution {
    public bool CanMeasureWater(int x, int y, int z) 
    {
        return z == 0 || (x + y >= z) && z % GCD(x, y) == 0;    
    }
    
    // 找最大公约数
    private int GCD(int x, int y)
    {
        return y == 0 ? x : GCD(y, x % y);
    }
}
