public class Solution {
    // 时间复杂度O(m+n)，空间复杂度O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        // 都是从后往前比较
        int index = m + n - 1;
        int pt1 = m - 1, pt2 = n - 1;
        while(pt1 >= 0 && pt2 >= 0)
        {
            if(nums1[pt1] <= nums2[pt2])
            {
                nums1[index--] = nums2[pt2--];
            }
            else
            {
                nums1[index--] = nums1[pt1--];
            }
        }
        // nums1还未遍历完
        while(pt1 >= 0)
        {
            nums1[index--] = nums1[pt1--];
        }
        // nums2还未遍历完
        while(pt2 >= 0)
        {
            nums1[index--] = nums2[pt2--];
        }
    }
}
