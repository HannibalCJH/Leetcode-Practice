public class Solution {
    // 参考https://discuss.leetcode.com/topic/16797/very-concise-o-log-min-m-n-iterative-solution-with-detailed-explanation
    // 时间复杂度O(log(min(m,n)))，我们只是二分查找较短数组寻找合适的切分点
    // 空间复杂度O(1
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int m = nums1.length, n = nums2.length;
        // 保证nums2是短的数组，这样我们可以保证时间复杂度控制住O(log(min(m,n)))
        if(m < n)
            return findMedianSortedArrays(nums2, nums1);
        
        // 如果nums2为空数组，即较短数组为空，那我们可以直接返回nums1的中位数
        if(n == 0)
            return ((double)nums1[(m - 1) / 2] + (double)nums1[m / 2]) / 2;
        
        // 切分点的位置有2n+1个，下标从0到2n，切分的位置可以是元素也可以是元素之间
        // 可以表示为[#,2,#,3,#,5,#,9,#]
        int left = 0, right = n * 2;
        while(left <= right)
        {
            // nums2的切分点
            int mid2 = (left + right) / 2;
            // 根据nums2的切分点计算nums1的切分点
            // 两个数组总的切分点应该有2m+2n+2个，其中两个位置我们用在切分点上所以可以忽略，
            // 我们要保证L1加L2的长度和R1加R2的长度都为m+n
            int mid1 = m + n - mid2;
            
            // L和R分别代表切分点左右两边的数，
            // 长度为奇数的数组可表示为[2, 3, (4/4), 5, 7]
            // 长度为偶数的数组可表示为[2, 3, / 5, 7]
            // 枚举长度从1到8的数组，很容易得出L、R和下标的关系为L = nums[(n-1)/2]，R = nums[n/2]
            // 这里有特殊情况，当切分点为数组的左右两边即超过数组的左右边界时，我们假设nums[-1]为最小整型数，
            // nums[n]为最大整型数，这样比较max(L1,L2)和min(R1,R2)时就不会取到这两边的值
            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = (mid1 == m * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            double R2 = (mid2 == n * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];
            
            // num1切分点的左边元素太多，我们应该让mid1向左边移动找到让L1小于等于R2的数字，
            // 根据mid1和mid2的关系，让mid1向左边移动即让mid2向右边移动
            if(L1 > R2)
                left = mid2 + 1;
            // num2切分点的左边元素太多，我们应该让mid2向左边移动找到让L2小于等于R1的数字，
            else if(L2 > R1)
                right = mid2 - 1;
            else
                return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;
    }
}
