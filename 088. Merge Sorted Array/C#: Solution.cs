public class Solution {
    public void Merge(int[] nums1, int m, int[] nums2, int n) 
    {
        int index = m + n - 1;
        int pt1 = m - 1, pt2 = n - 1;
        while(pt1 >= 0 || pt2 >= 0)
        {
            if(pt1 < 0)
            {
                nums1[index--] = nums2[pt2--];
            }
            else if(pt2 < 0)
            {
                nums1[index--] = nums1[pt1--];
            }
            else
            {
                nums1[index--] = nums1[pt1] <= nums2[pt2] ? nums2[pt2--] : nums1[pt1--];
            }
        }
    }
}
