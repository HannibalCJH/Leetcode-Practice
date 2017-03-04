public class Solution {
    // 短板效应
    // 时间复杂度O(n)，空间复杂度O(1)
    public int trap(int[] height) 
    {
        // 最起码要3个长度才能储水
        if(height == null || height.length < 3)
            return 0;
        
        int left = 0, right = height.length - 1;
        int area = 0;
        int smaller = 0;
        while(left < right)
        {
            // 左边界比右边界低
            if(height[left] < height[right])
            {
                // 设左边界为短板
                smaller = height[left];
                // 把所有小于等于左边界高度的面积加上，注意要包括等于，这样可以保证左指针继续往后移动
                while(left < right && height[left] <= smaller)
                {
                    area += smaller - height[left++];
                }
            }
            else
            {
                // 左边界比右边界高，设右边界为短板
                smaller = height[right];
                // 把所有小于等于右边界高度的面积加上，注意要包括等于，这样可以保证左指针继续往前移动
                while(left < right && height[right] <= smaller)
                {
                    area += smaller - height[right--];
                }
            }
        }
        return area;
    }
}
