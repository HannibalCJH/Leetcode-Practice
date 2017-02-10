public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public void sortColors(int[] nums) 
    {
        if(nums == null || nums.length == 0)
            return;
        // left指向左边连续0的后一个位置，right指向右边连续2的前一个位置
        int left = 0, right = nums.length - 1;
        int index = 0;
        // 思想是遇到0往前放，遇到2后放，中间余下的都是1
        while(index <= right)
        {
            // 遇到0，放到前面一串0的后面，这样连续0的长度就加1
            if(nums[index] == 0)
            {
                nums[index] = nums[left];
                nums[left++] = 0;
                // 我们从左往右扫，左边肯定是有序的，直接index往后移动即可
                index++;
            }
            // 遇到2，放到后面一串2的前面，这样连续2的长度就加1
            else if(nums[index] == 2)
            {
                nums[index] = nums[right];
                nums[right--] = 2;
            }
            else
                // 遇到1直接过
                index++;
        }
    }
}
