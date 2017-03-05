public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public int lengthOfLongestSubstring(String s) 
    {
        if(s == null || s.length() == 0)
            return 0;
        
        int[] bitmap = new int[128];
        // 初始化数组为-1，不然移动left指针一开始就会移动，
        // 因为默认数组元素都是0，bitmap[cur] >= left会判断会真
        Arrays.fill(bitmap, -1);
        int left = 0, right = 0;
        int maxLength = 1;
        while(right < s.length())
        {
            char cur = s.charAt(right);
            maxLength = Math.max(right - left, maxLength);
            if(bitmap[cur] >= left)
                left = bitmap[cur] + 1;
            bitmap[cur] = right++;
        }
        return Math.max(maxLength, right - left);
    }
}
