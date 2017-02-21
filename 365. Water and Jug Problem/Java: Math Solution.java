public class Solution {
    // 参考博文: https://www.hrwhisper.me/leetcode-water-jug-problem/
    // 时间复杂度O(n)，递归次数
    // 空间复杂度O(n)，递归栈空间
	public boolean canMeasureWater(int x, int y, int z) 
	{
        return z == 0 || (x + y >= z) && z % gcd(x, y) == 0;
    }
    // 裴蜀定理：ax + by = d的解为d = gcd(x, y)
	// 找最大公约数，辗转相除法（欧几里德算法）：gcd(a,b) = gcd(b, a mod b)
    private int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
}
