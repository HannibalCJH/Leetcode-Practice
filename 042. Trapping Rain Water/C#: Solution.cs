public class Solution {
    public int Trap(int[] height) 
    {
        if(height == null || height.Length < 3)
            return 0;
        
        int left = 0, right = height.Length - 1;
        int smaller = 0;
        int area = 0;
        while(left < right)
        {
            if(height[left] < height[right])
            {
                smaller = height[left];
                while(left < right && height[left] <= smaller)
                {
                    area += smaller - height[left++];
                }
            }
            else
            {
                smaller = height[right];
                while(left < right && height[right] <= smaller)
                {
                    area += smaller - height[right--];
                }
            }
        }
        return area;
    }
}
