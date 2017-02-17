/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    // 时间复杂度O(nlogn)，空间复杂度O(1)
    public int firstBadVersion(int n) 
    {
        int left = 1, right = n;
        // 二分法
        while(left < right)
        {
            // 取中点，这里如果表达式用(left+right)/2虽然在
            int mid = left + (right - left) / 2;
            // 注意是right=mid而不是mid-1，如果mid刚好指向第一个bad version，right=mid-1就会跳过这个version
            // 你二分的left到mid-1之间是找不到bad version的
            if(isBadVersion(mid))
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return left;
    }
}
