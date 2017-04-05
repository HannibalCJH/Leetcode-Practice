public class Solution {
    public int HIndex(int[] citations) 
    {
        int n = citations.Length;
        int left = 0, right = n - 1;
        while(left <= right)
        {
            int mid = (left + right) / 2;
            if(citations[mid] < n - mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return n - left;
    }
}
