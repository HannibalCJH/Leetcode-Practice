public class Solution {
    // 时间复杂度O(max(m, n))，空间复杂度O(m+n)
    public int compareVersion(String version1, String version2) 
    {
        // 根据"."分割字符串，需要转义字符
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int m = ver1.length, n = ver2.length;
        // 一直到长的数组也遍历完
        for(int i = 0; i < Math.max(m, n); i++)
        {
            // 如果一个数组已经被遍历完，余下的部分视为0
            int nums1 = i < m ? Integer.parseInt(ver1[i]) : 0;
            int nums2 = i < n ? Integer.parseInt(ver2[i]) : 0;
            if(nums1 < nums2)
                return -1;
            else if(nums1 > nums2)
                return 1;
        }
        // 所有部分都相等
        return 0;
    }
}
