public class Solution {
    public int CompareVersion(string version1, string version2) 
    {
        string[] ver1 = version1.Split('.');
        string[] ver2 = version2.Split('.');
        int m = ver1.Length, n = ver2.Length;
        for(int i = 0; i < Math.Max(m, n); i++)
        {
            int nums1 = i < m ? Int32.Parse(ver1[i]) : 0;
            int nums2 = i < n ? Int32.Parse(ver2[i]) : 0;
            if(nums1 < nums2)
                return -1;
            else if(nums1 > nums2)
                return 1;
        }
        return 0;
    }
}
