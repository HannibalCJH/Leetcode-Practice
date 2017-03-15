public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int m = nums1.Length, n = nums2.Length;
        if(m < n)
            return FindMedianSortedArrays(nums2, nums1);
            
        if(n == 0)
            return ((double)nums1[(m - 1) / 2] + (double)nums1[m / 2]) / 2;
        
        int left = 0, right = n * 2;
        while(left <= right)
        {
            int mid2 = (left + right) / 2;
            int mid1 = m + n - mid2;
            
            double L1 = (mid1 == 0) ? Int32.MinValue : nums1[(mid1 - 1) / 2];
            double L2 = (mid2 == 0) ? Int32.MinValue : nums2[(mid2 - 1) / 2];
            double R1 = (mid1 == 2 * m) ? Int32.MaxValue : nums1[mid1 / 2];
            double R2 = (mid2 == 2 * n) ? Int32.MaxValue : nums2[mid2 / 2];
        
            if(L1 > R2)
                left = mid2 + 1;
            else if(L2 > R1)
                right = mid2 - 1;
            else
                return (Math.Max(L1, L2) + Math.Min(R1, R2)) / 2;
        }
        return -1;
    }
}
